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
    
    public List<Product> getMens(){
        return repo.findAll(); /*implement sorting for mens */
    }
    public List<Product> getWomens(){
        return repo.findAll(); /*implement sorting for womens */
    }
    
    public List<Product> getShoes(){
        return repo.findByProductType("shoes");
    }  
    public List<Product> getShirts(){
        return repo.findByProductType("shirt");
    }
    public List<Product> getPants(){
        return repo.findByProductType("pants");
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
