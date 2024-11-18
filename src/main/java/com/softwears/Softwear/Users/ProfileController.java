package com.softwears.Softwear.Users;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softwears.Softwear.config.MyUserDetails;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/profile")
public class ProfileController {
/* this will link to the actaul profile page of the user. If the user is an employee,
 they will have the same features as a customer e.g updating credentials viewing purchase history(maybe) but they will have additional features.
 Like a simple product manager where an employee can add, remove, or update a product  */

@GetMapping
public String getProfilePage(Model model, HttpSession session, Principal principal) {
    Authentication authentication = (Authentication) principal;
    MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
    
    model.addAttribute("role", userDetails.getUser().getuserRole());
    model.addAttribute("name", userDetails.getUser().getuserFname());
    return "profile";
}

}
