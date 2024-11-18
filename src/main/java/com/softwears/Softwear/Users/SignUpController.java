package com.softwears.Softwear.Users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SignUpController {
/*will link to sign up controller when the page is made and will handle its logic 
i.e creating an account and storing it in the database */

@GetMapping("/Register")
public String showSignUp() {
    return "Register";
}

}
