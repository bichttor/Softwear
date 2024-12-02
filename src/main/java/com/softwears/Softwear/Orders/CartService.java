package com.softwears.Softwear.Orders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwears.Softwear.Products.Product;
import com.softwears.Softwear.Products.ProductRepository;
import com.softwears.Softwear.Users.Users;

@Service
public class CartService {
    
    @Autowired
    public CartRepository cartRepository;
    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public CartItemRepository cartItemRepository;
    @Autowired
    public OrdersRepository ordersRepository;

    @Autowired
    private OrdersService ordersService;

        public void addProductToCart(int cartId, int productId) {


            Cart cart = cartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));

         //   Orders order = ordersRepository.findByCartId(cartId);
                   // .orElseThrow(() -> new RuntimeException("Order not found"));
           
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            // Check if a CartItem already exists for the product in the cart

    Optional<CartItem> existingCartItem = cartItemRepository.findByCartAndProduct(cart, product);
    cart.setCartCount(cart.getCartCount() + 1);

    if (existingCartItem.isPresent()) {
        // Update the existing CartItem
         CartItem cartItem = existingCartItem.get();
        cartItem.setCartItemCount(cartItem.getCartItemCount() + 1); // Increment count
        cartItem.setCartItemPrice(cartItem.getCartItemCount() * product.getProductPrice()); // Update price
        cartItemRepository.save(cartItem);

    } else {
       
        CartItem cartItem = new CartItem(product.getProductPrice(), 1,cart, product);
        cartItemRepository.save(cartItem);
        
    }

    //all cart items sum
    List<CartItem> cartItems = cartItemRepository.findByCart(cart);
    double totalPrice = 0;
    for (CartItem item : cartItems) {
        totalPrice += item.getCartItemPrice(); 
    }
   // order.setOrderPrice(totalPrice);

    //Orders order = ordersRepository.findByOrderId(orderId);


    cart.setCartPrice(totalPrice);

    Orders order = cart.getOrderId();
    if (order != null) {
        order.setOrderPrice(totalPrice);
        order.setOrderDate(getOrderDate(cart.getId()));
        ordersRepository.save(order);
    }
    
   // order.setOrderPrice(totalPrice);
      //      ordersRepository.save(order);
            cartRepository.save(cart);
    }

    public void removeProductFromCart(Cart cart, int productId) {
        
        // cart = cartRepository.findById(cart.getId())
        //.orElseThrow(() -> new RuntimeException("Cart not found"));

   // Orders order = ordersRepository.findById(cart.getId())
     //   .orElseThrow(() -> new RuntimeException("Order not found"));
        
                    
        // Check if a CartItem already exists for the product in the cart
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        Optional<CartItem> existingCartItem = cartItemRepository.findByCartAndProduct(cart, product);
        
        if (existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            // Update the existing CartItem
            cartItem.setCartItemCount(cartItem.getCartItemCount() - 1); // Increment count 
            cartItem.setCartItemPrice(cartItem.getCartItemCount() * product.getProductPrice()); // Update price
            cartItemRepository.save(cartItem);
            

            if(cartItem.getCartItemCount() <= 0) {
                cartItemRepository.delete(existingCartItem.get());
                cart.setCartCount(cart.getCartCount() - 1);
                cartRepository.save(cart);
            } else {
                cart.setCartCount(cart.getCartCount() - 1);
            }
        } else {
            throw new RuntimeException("CartItem not found");
        }

        
        //all cart items sum
        List<CartItem> cartItems = cartItemRepository.findByCart(cart);
        double totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += item.getCartItemPrice(); 
        }
     
        cart.setCartPrice(totalPrice);

        Orders order = cart.getOrderId();
        if (order != null) {
            order.setOrderPrice(totalPrice);
            ordersRepository.save(order);
        }

        cartRepository.save(cart);
    }

    public Cart getOrCreateCartForUser(Users user) {
        return cartRepository.findByCustomerID(user).orElseGet(() -> {
        
            
            Orders order = new Orders(user);
            Cart newCart = new Cart(user, order); // Create new cart if not found
            
            if (order != null) {
                order.setOrderStatus("Pending");
            }

            cartRepository.save(order);
            ordersRepository.save(order);
            cartRepository.save(newCart);
            return newCart;
        });
    }

    public LocalDateTime getOrderDate(int cartId) {

    Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

    Orders order = cart.getOrderId(); // Get the associated order

    if (order != null) {
        return order.getOrderDate(); // Return the order date
    } else {
        throw new RuntimeException("Order not found for this cart");
    }
}
    public List<Cart> getCart(){
        return cartRepository.findAll();
    }
    public Optional<Cart> getCartId(int id){        
        return cartRepository.findById(id);
    }
    public Optional<Cart> getCartId(Users user){        
        return cartRepository.findByCustomerID(user);
    }
     public void addCart(Cart cart){
        cartRepository.save(cart);
    }
    public void updateCart(Cart cart){
        cartRepository.save(cart);
    }
    public void deleteCart(int id){
        cartRepository.deleteById(id);
    }
}
