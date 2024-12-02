package com.softwears.Softwear.Orders;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwears.Softwear.Users.Users;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
    //List<Orders> findByOrdersId(Orders orderId);
    List<Orders> findByCustomerId(Users customerId);
    //Orders findByCart(Cart cart);
   // Orders findByCartId(int cartId);
   Optional<Orders> findById(Integer orderId);
    Optional<Orders> findByOrderId(Orders orderId);
}
