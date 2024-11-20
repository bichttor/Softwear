package com.softwears.Softwear.Orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer>{
    List<OrderItems> findByOrderItemsId(OrderItems orderItemsId);
}
