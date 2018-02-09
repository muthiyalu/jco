package org.jco.applications.services;

import com.google.api.client.util.Sets;
import org.jco.applications.domain.AuthUser;
import org.jco.applications.domain.user.User12T;
import org.jco.applications.domain.user.User12TRepo;
import  org.jco.applications.domain.user.auth.AuthPG;
import org.jco.applications.domain.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
//    private final HashMap<String, User> userMap = new HashMap<>();

    @Autowired
    User12TRepo user12TRepo;


    @Override
    public final User loadUserByUsername(String username) throws UsernameNotFoundException {


        final User12T user = user12TRepo.findByEmail(username);
        if (user == null){

            throw new UsernameNotFoundException("user not found");


        }

        AuthUser authUser =new AuthUser(user.getEmail(),null, Collections.emptySet(),(AuthPG)user.getPropertyGroup("AuthPG."));


        detailsChecker.check(authUser);
        return authUser;
    }

    public void addUser(User user) {

        AuthUser authUser = (AuthUser) user;

        User12T user12T =new User12T();

        user12T.setEmail(authUser.getEmail());
        user12T.setUserName(authUser.getUsername());
        user12T.addPropertyGroup(authUser.getPropertyGroup(),"AuthPG");

        user12TRepo.save(user12T);

    }
}
