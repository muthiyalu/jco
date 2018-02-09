package org.jco.applications.domain.user.auth;


import org.jco.applications.domain.core.PropertyGroup;

public class AuthPG implements PropertyGroup {
    public AuthPG(String accessToken, String refreshToken, boolean isAuthenticated) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.isAuthenticated = isAuthenticated;
    }

    public AuthPG(String accessToken, String refreshToken) {

        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    private String accessToken = null;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public boolean isHasProvidedL1Auth() {
        return hasProvidedL1Auth;
    }

    public void setHasProvidedL1Auth(boolean hasProvidedL1Auth) {
        this.hasProvidedL1Auth = hasProvidedL1Auth;
    }

    private String refreshToken = null;


    private boolean isAuthenticated = false;

    private boolean hasProvidedL1Auth = false;

}