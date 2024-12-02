package com.softwears.Softwear.Orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.softwears.Softwear.Users.Users;

import jakarta.transaction.Transactional;

@Service
public class OrdersService {
    

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getOrders(){
        return ordersRepository.findAll();
    }
    public List<Orders> getOrderbyCustomer(Users user){
        return ordersRepository.findByCustomerId(user);
    }
    public Orders getOrdersId(int id){        
        return ordersRepository.findById(id).orElse(new Orders());
    }
     public void addOrders(Orders orders){
        ordersRepository.save(orders);
    }
    public void updateOrders(Orders orders){
        ordersRepository.save(orders);
    }
    public void deleteOrders(int id){
        ordersRepository.deleteById(id);
    }
    @Transactional
    public void updateOrderPriceFromCart(Orders orderId) {
        // Fetch the Cart based on the orderId
        Cart cart = cartRepository.findByOrderId(orderId);

        if (cart != null) {
            // Fetch the Order by orderId
            Optional<Orders> orderOpt = ordersRepository.findByOrderId(orderId);
            if (orderOpt.isPresent()) {
                Orders order = orderOpt.get();
                // Set the price of the Order to be the price from the Cart
                order.setOrderPrice(cart.getCartPrice());
                ordersRepository.save(order);  // Save the updated order
            }
        }
    }
  
    // Method to get orders sorted by date
    public List<Orders> getOrdersSortedByDate() {
        return ordersRepository.findAll(Sort.by(Sort.Order.desc("orderDate")));
    }

    // Method to get orders sorted by customer
    public List<Orders> getOrdersSortedByCustomer() {
        return ordersRepository.findAll(Sort.by(Sort.Order.asc("customerId")));
    }

    // Method to get orders sorted by dollar amount (order total)
    public List<Orders> getOrdersSortedByAmount() {
        return ordersRepository.findAll(Sort.by(Sort.Order.desc("orderPrice")));
    }
}
