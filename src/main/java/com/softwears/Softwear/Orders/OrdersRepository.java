package com.softwears.Softwear.Orders;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
    //List<Orders> findByOrdersId(Orders orderId);
}
