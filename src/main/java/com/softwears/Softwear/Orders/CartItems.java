package com.softwears.Softwear.Orders;

import com.softwears.Softwear.Products.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*Using the Entity tag creates a table with the values given so no schema will have to be written 
 * You can essentially copy and paste this file for other data and just change the respective values
*/

@Entity
@Table(name = "cart_items") /* set for data integrity */
public class CartItems{
    /*@Columns are set for data integrity */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "cart_item_count") 
    private int itemCount;

    @Column(name = "cart_item_price") 
    private double itemPrice;

    public CartItems(Cart cart, Product product){
        this.cart = cart;
        this.product = product;
        this.itemCount = 1;
        this.itemPrice = product.getProductPrice();
    }

    public CartItems(Cart cart, Product product, int itemCount){
        this.cart = cart;
        this.product = product;
        this.itemCount = itemCount;
        this.itemPrice = product.getProductPrice();
    }

    public CartItems(Cart cart, Product product, int itemCount, int itemPrice){
        this.cart = cart;
        this.product = product;
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
    }
}
