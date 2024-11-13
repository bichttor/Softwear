package com.softwears.Softwear.Orders;

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
@Table(name = "cart_items") /* set for data integrity */
public class CartItems {
    /*@Columns are set for data integrity */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cartItemsId;

    @Column(name = "cart_item_price") 
    private double cartPrice;

    @Column(name = "cart_item_count") 
    private int cartCount;

    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "product_id")
    private int productId;

    public CartItems() {}

    public CartItems(int cartPrice, int cartCount, int cartId, int productId){
        this.cartPrice = cartPrice;
        this.cartCount = cartCount;
        this.cartId = cartId;
        this.productId = productId;
    } 

    /* Getters & Setters */

    public int getCartItemsId() {
        return cartItemsId;
    }

    public void setCartItemsId(int cartItemsId) {
        this.cartItemsId = cartItemsId;
    }

    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public int getCartCount() {
        return cartCount;
    }

    public void setCartCount(int cartCount) {
        this.cartCount = cartCount;
    }

    public int getCartID() {
        return cartId;
    }

    public void setCartID(int cartId) {
        this.cartId = cartId;
    }

    public int getProductID() {
        return productId;
    }

    public void setProductID(int productId) {
        this.productId = productId;
    }

}
