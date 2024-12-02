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
import com.softwears.Softwear.Payments.Discounts;
import com.softwears.Softwear.Payments.DiscountsService;
import com.softwears.Softwear.Products.Product;
import com.softwears.Softwear.Products.ProductService;
import com.softwears.Softwear.config.MyUserDetails;

import jakarta.servlet.http.HttpSession;





@Controller
@RequestMapping("/employee")
@SessionAttributes({ "fname","products","orders","users","discounts"})
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
    public String getEmployeePage(@RequestParam(required = false) String sortBy,
    Model model, HttpSession session, Principal principal) {
        Authentication authentication = (Authentication) principal;
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
    
        model.addAttribute("fname", userDetails.getUser().getUserFname());
        /* Retrieves all orders, with sorting if a parameter is provided */
        List<Orders> orders;
        if (sortBy != null) {
        orders = switch (sortBy) {
                case "date" -> ordersService.getOrdersSortedByDate();
                case "customer" -> ordersService.getOrdersSortedByCustomer();
                case "dollars" -> ordersService.getOrdersSortedByAmount();
                default -> ordersService.getOrders();
            }; 
        } 
        else {
            orders = ordersService.getOrders(); // Default to unsorted orders
        }

        if (orders.isEmpty()) {
            model.addAttribute("message", "No previous orders");
        } else {
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
        /*Retrieves all Products */
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

    /*For searching */
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
    /*map for updating stock */
    @PostMapping("/stock/update")
    public String updateProdcut(@RequestParam int id, @RequestParam(required=false) int quantity,
    @RequestParam(required=false) double price, Model model, 
    RedirectAttributes redirectAttributes) {

        try {
            // Call service to update the product
            productsService.updateProduct(id, price, quantity);
            redirectAttributes.addFlashAttribute("message", "Product updated successfully.");
            model.addAttribute("products", productsService.getProducts()); /*updates view */
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating product: " + e.getMessage());
        }
        return "redirect:/employee#stock";
    }
    
    /*map for updating discounts */
    @PostMapping("/discounts")
    public String updateDiscounts(@RequestParam int id, @RequestParam(required=false) String code,
    @RequestParam (required=false) String applicable,@RequestParam(required=false)  double amount,
     Model model,  RedirectAttributes redirectAttributes) {
        try{
            discountsService.updateDiscounts(id,code,applicable,amount);
            redirectAttributes.addFlashAttribute("message", "Discount updated successfully.");
            model.addAttribute("discounts", discountsService.getAllDiscounts()); /*updates view */
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating discount: " + e.getMessage());
        
        }
        
        return "employee";
    }
    
}
