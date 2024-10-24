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
@Table(name = "product") /* set for data consistency */
public class Product {
    /*@Columns are set for data consistency */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int    id;
    @Column(name = "product_name") 
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_type")
    private String productType; /*Shoes, Shirts, Pants, .... for sorting*/
   
    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "sales_status")
    private int salesStatus; /*0 for avaliable, 1 for sold , for updating database i.e not showing sold items/allowing sold items to be sold again*/

    @Column(name = "product_image") 
    private String productImage;
    public Product(){}

    public Product(String name, double price, String description, String type, int sales, String image){
        this.productName = name;
        this.productPrice = price;
        this.productDescription = description;
        this.productType = type;
        this.salesStatus = sales;
        this.productImage = image;
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
    public int getStatus(){
        return salesStatus;
    }
    public String getImage(){
        return productImage;
    }
}
