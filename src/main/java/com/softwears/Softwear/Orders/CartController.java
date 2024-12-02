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

import com.softwears.Softwear.Payments.Invoice;
import com.softwears.Softwear.Payments.InvoiceService;
import com.softwears.Softwear.Payments.PaymentDetails;
import com.softwears.Softwear.Payments.PaymentDetailsService;
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
    @Autowired
    PaymentDetailsService paymentDetailsService;
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrdersRepository ordersRepository;

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

    @PostMapping("/cart/paymentDetails")
    public String fillPaymentDetails(@RequestParam(required = true) String cardNumber,
                                    @RequestParam(required = true) String cardName,
                                    @RequestParam(required = true) String expirationDate,
                                    @RequestParam(required = true) double cvv,
                                    @RequestParam(required = true) String cardType,
                                    @RequestParam(required = true) String cardFunction,
                                    @RequestParam(required = true) String bank, Model model, Principal principal) {
    
        Users customerId = getUserFromPrincipal(principal);
        PaymentDetails paymentDetails = new PaymentDetails(cardNumber, cardName, expirationDate, cvv, cardType, cardFunction,bank,customerId);
        paymentDetailsService.addPaymentDetails(paymentDetails);

        return "redirect:/cart";
    }

    @PostMapping("/cart/paymentSubmission")
    public String submitPayment(@RequestParam(value = "cartId", required = false) Integer cartId, Model model, Principal principal) {
        Users user = getUserFromPrincipal(principal);
        Cart cart = cartService.getCartId(user).orElseThrow(() -> new RuntimeException("Cart not found"));
    
        Orders order = cart.getOrderId(); // Get the associated order
    
        try {
            Invoice invoice = invoiceService.createInvoice(order.getOrderId()); // Pass the orderId
            model.addAttribute("message", "Payment successful. Invoice ID: " + invoice.getInvoiceId());
            order.setOrderStatus("Complete");
            ordersRepository.save(order);


            return "redirect:/cart"; // Redirect to a success page or display a confirmation
        } catch (RuntimeException e) {
            model.addAttribute("error", "Error processing payment: " + e.getMessage());
            return "error"; // Redirect to an error page
        }
    }
    
    public Users getUserFromPrincipal(Principal principal) {

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

        return user;
    }
    
}
