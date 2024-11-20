package com.softwears.Softwear.Orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Integer>{
    List<CartItems> findByCartItemsId(CartItems cartItemsId);
}
