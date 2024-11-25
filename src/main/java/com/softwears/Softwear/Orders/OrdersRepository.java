package com.softwears.Softwear.Orders;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwears.Softwear.Users.Users;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
    //List<Orders> findByOrdersId(Orders orderId);
    List<Orders> findByCustomerId(Users customerId);
}
