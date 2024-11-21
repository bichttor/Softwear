package com.softwears.Softwear.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
            .authorizeHttpRequests(request -> request.requestMatchers("/profile/**").authenticated() // Only the /profile page requires authentication
            .requestMatchers("/employee/**").hasRole("EMPLOYEE")
            .anyRequest().permitAll())
            .formLogin(login -> login
                    .loginPage("/login")
                    .successHandler((request, response, authentication) -> {
                        // Redirect to the profile page after login
                      if (authentication.getAuthorities().stream()
                        .anyMatch(authority -> authority.getAuthority().equals("ROLE_EMPLOYEE"))) {
                      response.sendRedirect("/employee"); // Redirect employees
                     } else if (authentication.getAuthorities().stream()
                        .anyMatch(authority -> authority.getAuthority().equals("ROLE_CUSTOMER"))) {
                      response.sendRedirect("/profile"); // Redirect customers
                     } else {
                      response.sendRedirect("/"); // Fallback redirect
                    }
                    })
                    .permitAll());

   return http.build();
}

  @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  
    }
 @Bean
 public AuthenticationProvider authenticationProvider(){
   DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
   provider.setUserDetailsService(myUserDetailsService);
   return provider;
 }
}