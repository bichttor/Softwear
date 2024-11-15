package com.softwears.Softwear.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.softwears.Softwear.Users.Customer;

public class MyUserDetails implements UserDetails{

    private final Customer customer;

    public MyUserDetails(Customer customer){
        this.customer = customer;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return Collections.singleton(new SimpleGrantedAuthority("CUSTOMER"));
    }

    @Override
    public String getPassword() {
        return customer.getcustomerPassword();
    }

    @Override
    public String getUsername() {
        return customer.getcustomerEmail();
    }

}
