package com.softwears.Softwear.Products;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/*Using the Entity tag creates a table with the values given so no schema will have to be written */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int  id;
    private String productName;
    private String productDescription;
    private String productType; /*Shoes, Shirts, Pants, .... for sorting*/
    private double productPrice;
    
    public Product(){}

    public Product(String name, double price, String description, String type){
        this.productName = name;
        this.productPrice = price;
        this.productDescription = description;
        this.productType = type;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return productName;
    }
    public String getDescription(){
        return productDescription;
    }
    public String getType(){
        return productType;
    }
    public double getPrice(){
        return productPrice;
    }
}
