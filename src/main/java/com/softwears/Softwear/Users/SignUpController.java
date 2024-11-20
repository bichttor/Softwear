package com.softwears.Softwear.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class SignUpController {
/*Will link to sign up controller when the page is made and will handle its logic 
i.e creating an account and storing it in the database */
    @Autowired
    UsersService usersService;
    @PostMapping("/sign-up")
    public String postSignUp(@RequestParam(required = true) String first, 
      @RequestParam(required = true) String last,
      @RequestParam(required = true) String  email,
      @RequestParam(required = true) String password,
      @RequestParam(required = true) String phone,
      Model model) {
        Users newUser = new Users(first, last, email, phone, password, phone, null);
        usersService.addUser(newUser);
        return "signup";
    }
    
}
