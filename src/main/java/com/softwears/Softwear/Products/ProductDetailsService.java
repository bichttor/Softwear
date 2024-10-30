package com.softwears.Softwear.Products;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsService {
    @Autowired
    private ProductDetailsRepository repo;

    public List<ProductDetails> getProductDetails() {
        return repo.findAll();
    }

    public ProductDetails getProductDetailsId(int productDetailsId) {
        return repo.findById(productDetailsId).orElse(new ProductDetails());
    }

    public List<ProductDetails> getColor(String color) {
        List<ProductDetails> productDetails;
        productDetails = repo.findByProductColor("black");
        productDetails.addAll(repo.findByProductColor(color));
        return productDetails;
    }
    public List<ProductDetails> getSize(String size) {
        List<ProductDetails> productDetails;
        productDetails = repo.findByProductSize("Medium");
        productDetails.addAll(repo.findByProductSize(size));
        return productDetails;
    }
    public List<ProductDetails> searchWeight(double weight) {
        return repo.findByProductWeight(weight);
    }
    public void addProductDetails(ProductDetails productDetails) {
        repo.save(productDetails);
    }
    public void updateProductDetails(ProductDetails productDetails) {
        repo.save(productDetails);
    }
    public void deleteProductDetails(int productDetailsId) {
        repo.deleteById(productDetailsId);
    }
}
