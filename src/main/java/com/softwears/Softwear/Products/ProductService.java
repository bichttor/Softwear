package com.softwears.Softwear.Products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {
    @Autowired
    ProductRespository repo;

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductId(int id){
        return repo.findById(id).orElse(new Product());
    }

    public void addProduct(Product product){
        repo.save(product);
    }
    public void updateProduct(Product product){
        repo.save(product);
    }
    public void deleteProduct(int id){
        repo.deleteById(id);
    }
}
