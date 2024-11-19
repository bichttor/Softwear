package com.softwears.Softwear.Users;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softwears.Softwear.config.MyUserDetails;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/profile")
public class ProfileController {
/* this will link to the actaul profile page of the user. If the user is an employee,
 they will have the same features as a customer e.g updating credentials viewing purchase history(maybe) but they will have additional features.
 Like a simple product manager where an employee can add, remove, or update a product  */
    @Autowired
    UsersService usersService;
    @GetMapping
    public String getProfilePage(Model model, HttpSession session, Principal principal) {
        Authentication authentication = (Authentication) principal;
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        
        model.addAttribute("role", userDetails.getUser().getuserRole());
        model.addAttribute("fname", userDetails.getUser().getuserFname());
        model.addAttribute("lname", userDetails.getUser().getuserLname());
        model.addAttribute("email", userDetails.getUser().getuserEmail());
        model.addAttribute("phone", userDetails.getUser().getuserPhone());
        model.addAttribute("address", userDetails.getUser().getAddress());
        return "profile";
    }
    @PostMapping("/credentials")
    public String getCredentials(@RequestParam String email, @RequestParam String password, Principal principal, RedirectAttributes redirectAttributes) {
        Authentication authentication = (Authentication) principal;
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        int userId = userDetails.getUser().getId();
       /*Updating user credentials  */
        try {
            usersService.updateUserCredentials(userId, email, password);
            redirectAttributes.addFlashAttribute("message", "Credentials updated successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating credentials: " + e.getMessage());
        }
        return "redirect:/profile";
    }
    @PostMapping("/addresses")
    public String updateAddresses(Principal principal, RedirectAttributes redirectAttributes,@RequestParam String street,
    @RequestParam String city,
    @RequestParam String state,
    @RequestParam int zipCode,
    @RequestParam String country) {
        Authentication authentication = (Authentication) principal;
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        int userId = userDetails.getUser().getId();
        
        /* Updating user adddress */
        try { 
            usersService.updateAddress(userId, street, city, state, zipCode, country);
            redirectAttributes.addFlashAttribute("message", "Address updated successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating address: " + e.getMessage());
        }
    
        return "redirect:/profile";
    }
 
    @PostMapping("/stock")
    public String getStock( Principal principal, RedirectAttributes redirectAttributes) {
        Authentication authentication = (Authentication) principal;
        
        return "redirect:/profile";
    }
}
