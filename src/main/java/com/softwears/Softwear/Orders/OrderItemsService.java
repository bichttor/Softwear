package com.softwears.Softwear.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsService {
    
    @Autowired
    private OrderItemsRepository repo;

    public List<OrderItems> getOrderItems(){
        return repo.findAll();
    }
    public OrderItems getOrderItemsId(int id){        
        return repo.findById(id).orElse(new OrderItems());
    }
     public void addOrderItems(OrderItems orderItems){
        repo.save(orderItems);
    }
    public void updateOrderItems(OrderItems orderItems){
        repo.save(orderItems);
    }
    public void deleteOrderItems(int id){
        repo.deleteById(id);
    }
}
