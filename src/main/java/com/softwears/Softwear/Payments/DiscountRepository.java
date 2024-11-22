package com.softwears.Softwear.Payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiscountRepository extends JpaRepository<Discounts, Integer> {
    Discounts findByDiscountCode(String discountCode); /*finds discount */
}
