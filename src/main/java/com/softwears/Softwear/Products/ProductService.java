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
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    
    
    public List<Product> getGender(String Gender){
        List<Product> products;
        products = repo.findByProductGenderAndSalesQuantityGreaterThan("unisex", 0);
        products.addAll(repo.findByProductGenderAndSalesQuantityGreaterThan(Gender, 0));
        return products;
    }
    public List<Product> getTypeGender(String Type, String Gender){
        List<Product> products;
        products = repo.findByProductTypeAndProductGenderAndSalesQuantityGreaterThan(Type, "unisex", 0);
        products.addAll(repo.findByProductTypeAndProductGenderAndSalesQuantityGreaterThan(Type, Gender, 0));
        return products;
    }
    public List<Product> getType(String Type){
        return repo.findByProductTypeAndSalesQuantityGreaterThan(Type, 0);
    }  
    public List<Product> searchProducts(String Name){
        return repo.findByProductNameContainingIgnoreCase(Name);
    }
 
    public void addProduct(Product product){
        repo.save(product);
    }
    public void updateProduct(int id, double price, int quantity){
        Product product = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
            product.setProductPrice(price);
            product.setSalesQuantity(quantity);
        
        repo.save(product);
    }
    public void deleteProduct(int id){
        repo.deleteById(id);
    }
}
