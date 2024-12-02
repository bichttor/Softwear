package com.softwears.Softwear.Orders;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwears.Softwear.Users.Users;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
    Optional<Cart> findByCartId(Integer cartId);
    Optional<Cart> findByCustomerID(Users customerID);
    Cart findByOrderId(Orders orderId);
    void save(Orders order);
   
}
