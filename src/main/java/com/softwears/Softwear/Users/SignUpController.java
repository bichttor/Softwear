package com.softwears.Softwear.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class SignUpController {
/*Will link to sign up controller when the page is made and will handle its logic 
i.e creating an account and storing it in the database */
    @Autowired
    UsersService usersService;
    @GetMapping("/Register")

    public String showRegisterPage() {
        return "Register"; 
    }
    
    @PostMapping("/Register")
        public String postSignUp(@RequestParam(required = true) String first, 
      @RequestParam(required = true) String last,
      @RequestParam(required = true) String  email,
      @RequestParam(required = true) String password,
      @RequestParam(required = true) String phone) {
        Users newUser = new Users(first, last, email, phone, password, phone, null);
        usersService.addUser(newUser);
        return "Register";
    } 

}
