package com.softwears.Softwear.Users;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByCustomerEmailAndCustomerPassword(String customerEmail,String customerPassword);
    Optional<Customer> findByCustomerEmail(String customerEmail);
}
