package com.softwears.Softwear.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    
    @Autowired
    private CartItemRepository repo;

    
    public List<CartItem> getCartItems(){
        return repo.findAll();
    }
    public CartItem getCartItemId(int id){        
        return repo.findById(id).orElse(new CartItem());
    }
     public void addCartItems(CartItem cartItems){
        repo.save(cartItems);
    }
    public void updateCartItems(CartItem cartItems){
        repo.save(cartItems);
    }
    public void deleteCartItems(int id){
        repo.deleteById(id);
    }
}
