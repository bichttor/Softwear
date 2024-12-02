package com.softwears.Softwear.Orders;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softwears.Softwear.Users.Users;
import com.softwears.Softwear.Users.UsersService;
import com.softwears.Softwear.config.MyUserDetails;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class CartController {


    @Autowired
    CartItemService cartItemService;
    @Autowired
    CartService cartService;
    @Autowired
    UsersService usersService;

    @GetMapping("/cart")
    public String getPage(Model model, Principal principal) {
        Users user = usersService.findByuserEmail(principal.getName());
        Cart cart = cartService.getOrCreateCartForUser(user);
        

        List<CartItem> cartItems = cartItemService.getCartItemsByCart(cart);
        double totalPrice = cart.getCartPrice();
        
        model.addAttribute("cart", cart);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", totalPrice);
        return "ShoppingCart";
    }

    @PostMapping("/cart/add")
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
 
            return "redirect:/cart";
}

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam(value = "cartId", required = false) Integer cartId, @RequestParam("productId") int productId, Principal principal) {
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

        Cart cart = cartService.getCartId(user).orElseThrow(() -> new RuntimeException("Cart not found"));
        cartService.removeProductFromCart(cart, productId);
        return "redirect:/cart";
    }

    @PostMapping("/cart/payment")
    public String makePayment(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}
