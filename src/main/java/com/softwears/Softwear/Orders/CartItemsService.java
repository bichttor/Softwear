package com.softwears.Softwear.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CartItemsService {
    
    @Autowired
    private CartItemsRepository repo;

    
    public List<CartItems> getCartItems(){
        return repo.findAll();
    }
    public CartItems getCartItemsId(int id){        
        return repo.findById(id).orElse(new CartItems());
    }
     public void addCartItems(CartItems cartItems){
        repo.save(cartItems);
    }
    public void updateCartItems(CartItems cartItems){
        repo.save(cartItems);
    }
    public void deleteCartItems(int id){
        repo.deleteById(id);
    }
}
