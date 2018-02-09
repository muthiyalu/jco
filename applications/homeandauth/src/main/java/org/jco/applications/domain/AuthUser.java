 package org.jco.applications.domain;


import org.jco.applications.domain.core.PropertyGroup;
import org.jco.applications.domain.user.auth.AuthPG;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


@Data
public class AuthUser extends User {


  AuthPG authPG=null;


  private String email;

    public AuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities, AuthPG authPG){
     super(username, password, authorities);
     this.authPG=authPG;

     }




  public void setPropertyGroup(AuthPG propertyGroup) {

   authPG=(AuthPG)propertyGroup;

  }
  public AuthPG getPropertyGroup() {
   return authPG;
  }
}