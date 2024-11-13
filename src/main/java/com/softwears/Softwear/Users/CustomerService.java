package com.softwears.Softwear.Users;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;
     
    public List<Customer> getAllcustomers(){
        return repo.findAll();
    }

    public Customer getcustomerId(int id){
        return repo.findById(id).orElse(new Customer());
    }
    public boolean validateLogin(String customerEmail, String customerPassword){
        return repo.findByCustomerEmailAndCustomerPassword(customerEmail, customerPassword).isPresent();
    }   

    public void addcustomer(Customer customer){
        repo.save(customer);
    }

    public void updatecustomer(Customer customer){
        repo.save(customer);
    }

    public void deletecustomer(int id){
        repo.deleteById(id);
    }

}
