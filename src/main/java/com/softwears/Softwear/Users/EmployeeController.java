package com.softwears.Softwear.Users;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softwears.Softwear.Orders.Orders;
import com.softwears.Softwear.Orders.OrdersService;
import com.softwears.Softwear.Payments.Discounts;
import com.softwears.Softwear.Payments.DiscountsService;
import com.softwears.Softwear.Products.Product;
import com.softwears.Softwear.Products.ProductService;
import com.softwears.Softwear.config.MyUserDetails;

import jakarta.servlet.http.HttpSession;




@Controller
@RequestMapping("/employee")
@SessionAttributes({ "fname","products"})
public class EmployeeController {
    @Autowired
    ProductService productsService;
    @Autowired
    OrdersService ordersService;
    @Autowired
    UsersService usersService;
    @Autowired
    DiscountsService discountsService;

    @GetMapping
    public String getEmployeePage(Model model, HttpSession session, Principal principal) {
        Authentication authentication = (Authentication) principal;
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
    
        model.addAttribute("fname", userDetails.getUser().getUserFname());
        /*Retrieves all orders */
        List<Orders> orders = ordersService.getOrders();
        if(orders.isEmpty()){
            model.addAttribute("message", "No previous orders");
        }
        else{
            model.addAttribute("orders", orders);
        }
        /*Retrieves all Users */
        List<Users> users = usersService.getAllusers();
        if(users.isEmpty()){
            model.addAttribute("message", "No Users");
        }
        else{
            model.addAttribute("users", users);
        }
        if (!model.containsAttribute("products")) {
            model.addAttribute("products", productsService.getProducts()); // Default to all products
        }
        /*Retrieves all Discounts */
        List<Discounts> discounts = discountsService.getAllDiscounts();
        if(discounts.isEmpty()){
            model.addAttribute("message", "No Discounts");
        }
        else{
            model.addAttribute("discounts", discounts);
        }
        return "employee";
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
        return "redirect:/employee#stock";
    }

}
