package com.softwears.Softwear.Products;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductType(String productType); /* Allows for sorting by shoes,shirts, etc. */
    List<Product> findByProductGender(String productGender);  /*sorts by category */
    List<Product> findByProductTypeAndProductGender(String productType, String productGender); /* sorts by category and type */
    List<Product> findByProductNameContainingIgnoreCase(String productName); /*When search bar is implemented, will find products with similar name as provided */
    /*Will have to update methods to only show avaliable products */
}
