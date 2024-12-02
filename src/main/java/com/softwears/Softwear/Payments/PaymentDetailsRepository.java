package com.softwears.Softwear.Payments;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Integer> {
    List<PaymentDetails> findByPaymentDetailsId(int paymentDetailsId);
}