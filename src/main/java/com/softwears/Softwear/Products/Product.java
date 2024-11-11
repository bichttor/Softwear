package com.softwears.Softwear.Products;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*Using the Entity tag creates a table with the values given so no schema will have to be written 
 * You can essentially copy and paste this file for other data and just change the respective values
*/

@Entity
@Table(name = "product") /* set for data integrity */
public class Product {
    /*@Columns are set for data integrity */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int    id;
    @Column(name = "product_name") 
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_type")
    private String productType; /*Shoes, Shirts, Pants, .... for sorting*/

    @Column(name = "product_gender")
    private String productGender; /* male, female, unisex(will show for both male and female) */

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "sales_quantity")
    private int salesQuantity; /*When it is 0 remove from catalog*/

    @Column(name = "product_image") 
    private String productImage;
    public Product(){}

    public Product(String name, double price, String description, String type, int sales, String image, String gender){
        this.productName = name;
        this.productPrice = price;
        this.productDescription = description;
        this.productType = type;
        this.productGender = gender;
        this.salesQuantity = sales;
        this.productImage = image;
    }
    public void setId(int id){
        this.id = id;
    }
    
    /*Getters */
    public int getId(){
        return id;
    }
    public String getProductName(){
        return productName;
    }
    public String getProductDescription(){
        return productDescription;
    }
    public String getProductType(){
        return productType;
    } 
    public String getProductGender(){
        return productGender;
    }
    public double getProductPrice(){
        return productPrice;
    }
    public int getSalesQuantity(){
        return salesQuantity;
    }
    public String getProductImage(){
        return productImage;
    }
}
