package com.softwears.Softwear.Products;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductTypeAndSalesQuantityGreaterThan(String productType, int Quantity); /* Allows for sorting by shoes,shirts, etc. */
    List<Product> findByProductGenderAndSalesQuantityGreaterThan(String productGender, int Quantity);  /*sorts by category */
    List<Product> findByProductTypeAndProductGenderAndSalesQuantityGreaterThan(String productType, String productGender, int Quantity); /* sorts by category and type */
    List<Product> findByProductNameContainingIgnoreCase(String productName); /*When search bar is implemented, will find products with similar name as provided */
   
}
