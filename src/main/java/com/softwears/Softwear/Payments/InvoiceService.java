package com.softwears.Softwear.Payments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwears.Softwear.Orders.Orders;
import com.softwears.Softwear.Orders.OrdersRepository;
import com.softwears.Softwear.Users.Users;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository repo;

    public List<Invoice> getInvoice() {
        return repo.findAll();
    }
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private OrdersRepository orderRepository; 

    public Invoice createInvoice(int orderId) {

        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
                
        Users customer = order.getCustomerId();

        Invoice invoice = new Invoice();
        invoice.setCost(order.getOrderPrice()); 
        invoice.setDate(order.getOrderDate()); 
        invoice.setOrderId(order);
        invoice.setCustomerId(customer);

        return invoiceRepository.save(invoice);
    }
}
