package com.softwears.Softwear.Users;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softwears.Softwear.Products.Product;
import com.softwears.Softwear.Products.ProductService;
import com.softwears.Softwear.config.MyUserDetails;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/profile")
@SessionAttributes({"role", "fname", "lname", "email", "phone", "address","products"})
public class ProfileController {
    @Autowired
    UsersService usersService;
    @Autowired
    ProductService productsService;
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
        if (!model.containsAttribute("products")) {
            model.addAttribute("products", productsService.getProducts()); // Default to all products
        }
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

    @PostMapping("/orders")
    public String getOrders(Principal principal, RedirectAttributes redirectAttributes) {
        Authentication authentication = (Authentication) principal;
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        int userId = userDetails.getUser().getId();
        //fill in when orderservice is made
        return "redirect:/profile";
    }

    @GetMapping("/stock")
    public String getStock(@RequestParam(required=false) String query,Model model, RedirectAttributes redirectAttributes) {
        List<Product> products;
        if (query != null && !query.isEmpty()) {
            products = productsService.searchProducts(query); // Call search method
        } else {
            products = productsService.getProducts(); // Default to all products
        }
        model.addAttribute("products", products);
        return "redirect:/profile#stock";
    }
}