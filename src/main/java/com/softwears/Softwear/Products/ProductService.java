package com.softwears.Softwear.Products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductId(int id){
        return repo.findById(id).orElse(new Product());
    }
    
    public List<Product> getGender(String Gender){
        List<Product> products;
        products = repo.findByProductGender("unisex");
        products.addAll(repo.findByProductGender(Gender));
        return products;
    }
    public List<Product> getTypeGender(String Type, String Gender){
        List<Product> products;
        products = repo.findByProductTypeAndProductGender(Type,"unisex");
        products.addAll(repo.findByProductTypeAndProductGender(Type, Gender));
        return products;
    }
    public List<Product> getType(String Type){
        return repo.findByProductType(Type);
    }  
    public List<Product> searchProducts(String Name){
        return repo.findByProductNameContainingIgnoreCase(Name);
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
