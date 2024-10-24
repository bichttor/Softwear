package com.softwears.Softwear.Products;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByProductType(String type); /* Allows for sorting by shoes,shirts, etc. */
}
