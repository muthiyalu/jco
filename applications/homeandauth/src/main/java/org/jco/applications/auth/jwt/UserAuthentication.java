package org.jco.applications.auth.jwt;

import org.jco.applications.domain.AuthUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserAuthentication implements Authentication {

    private final AuthUser user;
    private boolean authenticated = true;

    public UserAuthentication(AuthUser user) {
        this.user = user;
    }

    @Override
    public String getName() {
        return user.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return user;
    }

    @Override
    public User getDetails() {
        return (User) user;
    }

    @Override
    public Object getPrincipal() {
        return user.getUsername();
    }

    @Override
    public boolean isAuthenticated() {
        return user.getAuthPG().isAuthenticated();
    }

    @Override


    public void setAuthenticated(boolean authenticated) {

        user.getAuthPG().setAuthenticated(authenticated);
    }
}
