package com.softwears.Softwear.Products;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>{
   
    List<ProductDetails> findByProductDetailsId(int productDetailsId);
    List<ProductDetails> findByProductColor(String productColor);
    List<ProductDetails> findByProductSize(String productSize);
    List<ProductDetails> findByProductWeight(double weight);
    ProductDetails findByProductId(Product product);
    /*
     * product id needs to be used as foreign key at some point..
     * find by product size
     * find by product id
     * find by product color
     * find by product detail id
     */
}
