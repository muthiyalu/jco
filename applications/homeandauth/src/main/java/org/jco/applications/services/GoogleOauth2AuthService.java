package org.jco.applications.services;

import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.googleapis.auth.oauth2.*;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.common.collect.Sets;

import org.jco.applications.auth.XsrfUtils;
import org.jco.applications.auth.jwt.UserAuthentication;
import org.jco.applications.domain.AuthUser;
import org.jco.applications.domain.user.auth.AuthPG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class GoogleOauth2AuthService implements Oauth2AuthService {


    private static String APPLICATION_NAME = "Royalseema-12Tracks/1.0";
    /** Global instance of the HTTP transport. */
    private static HttpTransport httpTransport;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();


    private static Oauth2 oauth2;
    private static GoogleClientSecrets clientSecrets=null;

    @Autowired
    private XsrfUtils xsrfUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;



    public GoogleOauth2AuthService() throws IOException{

        setClientSecrets();

    }


    public String getRedirectURIasString(String state, List<String> scopes){

        return new GoogleAuthorizationCodeRequestUrl(clientSecrets,clientSecrets.getDetails().getRedirectUris().get(0),scopes).setState(state).build();
    }


    public UserAuthentication getAuthenticationFromOAuth2Callback(String requestURL) throws Exception {


            AuthorizationCodeResponseUrl authResponse =
                    new AuthorizationCodeResponseUrl(requestURL);
            // check for user-denied error
            if (authResponse.getError() != null) {

            throw new Exception( "ERROR SENT DURING OUTH2CALLBACK " + authResponse.getError() );

            } else {

                GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(new NetHttpTransport(), new JacksonFactory(),
                                clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret(),
                                authResponse.getCode(), clientSecrets.getDetails().getRedirectUris().get(0))
                                .execute();

                String accessToken = tokenResponse.getAccessToken();
                String refreshToken= tokenResponse.getRefreshToken();

                String email=tokenResponse.parseIdToken().getPayload().getEmail();

                return establishUserAndLogin(email,accessToken,refreshToken);


            }



    }

    public String getErrorFromCallbackIfAny(String callbackURLStr){

        AuthorizationCodeResponseUrl authResponse =
                new AuthorizationCodeResponseUrl(callbackURLStr);


        if (authResponse.getError()!=null)

            return authResponse.getErrorDescription();

        else

            return null;
    }



    private void setClientSecrets(){

        if (clientSecrets==null){

            try {
                clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
                        new InputStreamReader(this.getClass().getResourceAsStream("/client_secrets-tmp.json")));


            } catch (IOException e) {
                System.out.println("Unable to load secrets+" + e.getMessage());
            }



        }
    }






    private UserAuthentication establishUserAndLogin( String email, String accessToken,String refreshToken ) {
        // Find user, create if necessary
        User user12t;
        AuthUser authUser =null;
        try {


            user12t = userService.loadUserByUsername(email);
        } catch (UsernameNotFoundException e) {

            AuthPG authPG =new AuthPG(accessToken, refreshToken,true);
             authUser= new AuthUser(email, UUID.randomUUID().toString(), Sets.<GrantedAuthority>newHashSet(),authPG);
            userService.addUser(authUser);
        }

       return new UserAuthentication((AuthUser)authUser);
    }







}
