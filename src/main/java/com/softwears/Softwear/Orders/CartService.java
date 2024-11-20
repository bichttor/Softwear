package com.softwears.Softwear.Orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class CartService {
    
    @Autowired
    public CartRepository repo;

    public List<Cart> getCart(){
        return repo.findAll();
    }
    public Optional<Cart> getCartId(int id){        
        return repo.findById(id);
        //return repo.findById(id).orElse(new Cart());
    }
     public void addCart(Cart cart){
        repo.save(cart);
    }
    public void updateCart(Cart cart){
        repo.save(cart);
    }
    public void deleteCart(int id){
        repo.deleteById(id);
    }
}
