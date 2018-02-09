package org.jco.applications.controllers;

import org.jco.applications.auth.XsrfUtils;
import org.jco.applications.auth.jwt.UserAuthentication;
import org.jco.applications.services.Oauth2AuthService;
import org.jco.applications.services.TokenAuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.jco.applications.services.Oauth2AuthService;
import org.jco.applications.services.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@Controller
public class GoogleOauth2Controller {


    /** OAuth 2.0 scopes. */
    private static final List<String> SCOPES = Arrays.asList(
            "https://www.googleapis.com/auth/userinfo.profile",
            "https://www.googleapis.com/auth/userinfo.email",
            "https://www.googleapis.com/auth/drive",
            "https://www.googleapis.com/auth/tasks");



    @Autowired
    Oauth2AuthService googleOauth2LoginService ;

    @Autowired
    TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    XsrfUtils xsrfUtils;

    @RequestMapping(value = "/auth/authorise", method = GET)
    public void authorise(HttpServletRequest request, HttpServletResponse response , HttpSession session) throws IOException,Exception{

        String state = xsrfUtils.newToken();
        request.getSession().setAttribute(XsrfUtils.XSRF_KEY, state);

        String redirectURl=googleOauth2LoginService.getRedirectURIasString(state,SCOPES);

        response.sendRedirect(redirectURl);


    }



    @RequestMapping(value = "/auth/oauth2callback", method = GET)
    public String oauth2callback(HttpServletRequest request, HttpServletResponse response , HttpSession session, Model model) throws IOException,Exception{

        // Check for a valid XSRF token
        String expectedToken = (String) request.getSession().getAttribute(XsrfUtils.XSRF_KEY);
        String actualToken = request.getParameter("state");
        if (!xsrfUtils.isValid(expectedToken, actualToken)) {

            log.error("Unauthorized XSRF token for Session Id: "+ session.getId() +". The actual token is :" + actualToken +"and expected Token is :" + expectedToken);

            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);


            return "error";
        }


        StringBuffer fullUrlBuf = request.getRequestURL();

        if (request.getQueryString() != null) {
            fullUrlBuf.append('?').append(request.getQueryString());
        } else {
            log.error(" BAD REQUEST obtained from provider for Session ID:"+ session.getId()+ ", the Query String is null");

            response.sendError(HttpServletResponse.SC_BAD_REQUEST);

            return "error";


        }

        String errorIfAny=googleOauth2LoginService.getErrorFromCallbackIfAny(fullUrlBuf.toString());

        // check for user-denied error
        if (errorIfAny!= null) {

            log.error(" Error  obtained from provider for Session ID:"+ session.getId()+ ", the error message String is:"+errorIfAny);

            response.sendError(HttpServletResponse.SC_BAD_REQUEST);

            return "error";

        }

        Authentication authentication = googleOauth2LoginService.getAuthenticationFromOAuth2Callback(fullUrlBuf.toString());


        String jwtToken=tokenAuthenticationService.addAuthentication(response, (UserAuthentication)authentication);

        request.setAttribute("authToken", jwtToken);

        model.addAttribute("user", authentication);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "login";

    }






}