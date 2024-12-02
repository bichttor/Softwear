package com.softwears.Softwear.Payments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailsService {
    @Autowired
    private PaymentDetailsRepository repo;

     public List<PaymentDetails> getPayment() {
        return repo.findAll();
    }

    public void addPaymentDetails(PaymentDetails paymentDetails) {

         repo.save(paymentDetails);
    }
}
