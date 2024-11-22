package com.softwears.Softwear.Payments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountsService {
    @Autowired
    DiscountRepository repo;

    public List<Discounts> getAllDiscounts() {
        return repo.findAll();
    }
    public Discounts getDiscountCode(String discountCode){
        return repo.findByDiscountCode(discountCode);
    }
}
