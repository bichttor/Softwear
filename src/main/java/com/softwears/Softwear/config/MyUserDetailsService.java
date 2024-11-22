package com.softwears.Softwear.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.softwears.Softwear.Users.Users;
import com.softwears.Softwear.Users.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
   
    @Autowired
    private UsersRepository repo;
    
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userOptional= repo.findByuserEmail(username);
        if(userOptional.isPresent()){
            Users user = userOptional.get();
            return new MyUserDetails(user);
        }
        else{
            throw new UsernameNotFoundException(username);
        }
        
    }

}
