package com.softwears.Softwear.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class OrdersService {
    

    @Autowired
    private OrdersRepository repo;

    public List<Orders> getOrders(){
        return repo.findAll();
    }
    public Orders getOrdersId(int id){        
        return repo.findById(id).orElse(new Orders());
    }
     public void addOrders(Orders orders){
        repo.save(orders);
    }
    public void updateOrders(Orders orders){
        repo.save(orders);
    }
    public void deleteOrders(int id){
        repo.deleteById(id);
    }
}
