package com.softwears.Softwear.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
public class SecurityConfig {

   @Autowired
   private  MyUserDetailsService myUserDetailsService; 
  
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(request -> request.requestMatchers("/profile").authenticated() // Only the /profile page requires authentication
            .requestMatchers("profile/stock").hasRole("EMPLOYEE")
            .anyRequest().permitAll())
            .formLogin(login -> login
                    .loginPage("/login")
                    .successHandler((request, response, authentication) -> {
                        // Redirect to the profile page after login
                        response.sendRedirect("/profile");
                    })
                    .permitAll());

   return http.build();
}


 @Bean
 public AuthenticationProvider authenticationProvider(){
   DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
   provider.setUserDetailsService(myUserDetailsService);
   return provider;
 }
}