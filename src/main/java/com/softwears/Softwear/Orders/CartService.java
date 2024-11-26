package com.softwears.Softwear.Orders;

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

        public void addProductToCart(int cartId, int productId) {


            Cart cart = cartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));

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
    cart.setCartPrice(totalPrice);

            cartRepository.save(cart);
    }

    public Cart getOrCreateCartForUser(Users user) {
        return cartRepository.findByCustomerID(user).orElseGet(() -> {
            Cart newCart = new Cart(user); // Create new cart if not found
            cartRepository.save(newCart);
            return newCart;
        });
    }

    public List<Cart> getCart(){
        return cartRepository.findAll();
    }
    public Optional<Cart> getCartId(int id){        
        return cartRepository.findById(id);
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
