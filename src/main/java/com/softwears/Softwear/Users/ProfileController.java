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

import com.softwears.Softwear.Orders.Orders;
import com.softwears.Softwear.Orders.OrdersService;
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
    @Autowired
    OrdersService ordersService;

    @GetMapping
    public String getProfilePage(Model model, HttpSession session, Principal principal) {
        Authentication authentication = (Authentication) principal;
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        /*Adds users credentials  */
        model.addAttribute("role", userDetails.getUser().getUserRole());
        model.addAttribute("fname", userDetails.getUser().getUserFname());
        model.addAttribute("lname", userDetails.getUser().getUserLname());
        model.addAttribute("email", userDetails.getUser().getUserEmail());
        model.addAttribute("phone", userDetails.getUser().getUserPhone());
        model.addAttribute("address", userDetails.getUser().getAddress());
        /*Adds Users Orders */
        List<Orders> orders = ordersService.getOrderbyCustomer(userDetails.getUser());
        if(orders.isEmpty()){
            model.addAttribute("message", "No previous orders");
        }
        else{
            model.addAttribute("orders", orders);
        }
        /*Adds products */
        if (!model.containsAttribute("products")) {
            model.addAttribute("products", productsService.getProducts()); 
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
}
