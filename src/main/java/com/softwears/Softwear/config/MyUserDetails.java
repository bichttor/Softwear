package com.softwears.Softwear.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.softwears.Softwear.Users.Users;

public class MyUserDetails implements UserDetails{

    private final Users user;

    public MyUserDetails(Users user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = "ROLE_" + user.getuserRole();
       return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return user.getuserPassword();
    }

    @Override
    public String getUsername() {
        return user.getuserEmail();
    }

}
