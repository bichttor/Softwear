package com.softwears.Softwear.Orders;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwears.Softwear.Products.Product;



@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
    List<CartItem> findByCart(Cart cart);
}
