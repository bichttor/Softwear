package com.softwears.Softwear.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.softwears.Softwear.Users.Customer;
import com.softwears.Softwear.Users.CustomerRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
   
    @Autowired
    private CustomerRepository customerRepo;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customerOptional= customerRepo.findByCustomerEmail(username);
        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            return User.builder()
                .username(customer.getcustomerEmail())
                .password(customer.getcustomerPassword())
                .build();
        }
        else{
            throw new UsernameNotFoundException(username);
        }
        
    }

}
