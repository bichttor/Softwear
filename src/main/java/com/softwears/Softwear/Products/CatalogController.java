package com.softwears.Softwear.Products;



import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softwears.Softwear.Orders.Cart;
import com.softwears.Softwear.Orders.CartItemService;
import com.softwears.Softwear.Orders.CartService;
import com.softwears.Softwear.Users.Users;
import com.softwears.Softwear.Users.UsersService;
import com.softwears.Softwear.config.MyUserDetails;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CatalogController {

     @Autowired
    CartItemService cartItemService;
    @Autowired
    CartService cartService;
    @Autowired
    UsersService usersService;
    @Autowired
    private ProductService productservice;
    
    @GetMapping("/catalog")
    public String getProducts(@RequestParam(required = false) String type ,@RequestParam(required = false) String gender
    ,@RequestParam(required = false) String query, Model model){
        List<Product> products;
        if (query != null && !query.isEmpty()) {
            products = productservice.searchProducts(query); // Call search method
            model.addAttribute("products", products);
            return "catalog";
        }
        else if (gender != null && !gender.equals("all") && type != null && !type.equals("all")) {
            products = productservice.getTypeGender(type, gender);
        } else if (gender != null && !gender.equals("all")) {
            products = productservice.getGender(gender);
        } else if (type != null && !type.equals("all")) {
            products = productservice.getType(type);
        } else {
            products = productservice.getProducts();
        }
        model.addAttribute("products", products);
        return "catalog";
    }

    @PostMapping("/catalog/add")
    public String addToCart(@RequestParam(value = "cartId", required = false) Integer cartId,
                        @RequestParam("productId") int productId, Principal principal) {

                            
                if (principal == null) {
                    throw new RuntimeException("User is not authenticated");
                }
                        Authentication authentication = (Authentication) principal;
                       
                        if (authentication == null || !authentication.isAuthenticated()) {
                            throw new RuntimeException("Authentication is invalid");
                        }
                        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
                                           
                        String username = userDetails.getUsername();
                        Users user = usersService.findByuserEmail(username); 

                        Cart cart;

            if (cartId == null || cartId == 0) {
                cart = cartService.getOrCreateCartForUser(user); // Create or retrieve the cart
            } else {
                cart = cartService.getCartId(cartId)
                        .orElseThrow(() -> new RuntimeException("Cart not found"));
            }

            //add count as add product to count is implemented
    cartService.addProductToCart(cart.getId(), productId);
 
            return "redirect:/catalog";
}
      
}
