package com.softwears.Softwear.Products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productDetailsId;

    @Column(name = "product_color")
    private String productColor;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_weight")
    private double productWeight;

    @Column(name = "product_size")
    private String productSize;

    @Column(name = "product_id")
    private int productId;

    public ProductDetails() {}

    public ProductDetails(String color, String description, double weight, String size, int id) {
        this.productColor = color;
        this.productDescription = description;
        this.productWeight = weight;
        this.productSize = size;
        this.productId = id;
    }

    public void setProductDetailsId(int productDetailsId) {
        this.productDetailsId = productDetailsId;
    }

    public int getProductDetailsId() {
        return productDetailsId;
    }
    public String getColor() {
        return productColor;
    }
    public String getDescription() {
        return productDescription;
    }
    public double getWeight() {
        return productWeight;
    }
    public String getSize() {
        return productSize;
    }
    public int getProductId() {
        return productId;
    }
}
