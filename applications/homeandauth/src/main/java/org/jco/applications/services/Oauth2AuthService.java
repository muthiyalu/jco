package org.jco.applications.services;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface
Oauth2AuthService {


    public String getRedirectURIasString(String state, List<String> scopes);


    public Authentication getAuthenticationFromOAuth2Callback(String requestURL) throws Exception;

//    public String handleOuth2Callback(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public String getErrorFromCallbackIfAny(String callbackURLStr);

}
