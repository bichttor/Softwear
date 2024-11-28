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
@Table(name = "cart_item") /* set for data integrity */
public class CartItem {
    /*@Columns are set for data integrity */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cartItemId;

    @Column(name = "cart_item_price") 
    private double cartItemPrice;

    @Column(name = "cart_item_count") 
    private int cartItemCount;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public CartItem() {}

    public CartItem(double cartItemPrice, int cartItemCount, Cart cartId, Product product){
        this.cartItemPrice = cartItemPrice;
        this.cartItemCount = cartItemCount;
        this.cart = cartId;
        this.product = product;
    } 

    /* Getters & Setters */

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public double getCartItemPrice() {
        return cartItemPrice;
    }

    public void setCartItemPrice(double cartItemPrice) {
        this.cartItemPrice = cartItemPrice;
    }

    public int getCartItemCount() {
        return cartItemCount;
    }

    public void setCartItemCount(int cartItemCount) {
        this.cartItemCount = cartItemCount;
    }

    public Cart getCartId() {
        return cart;
    }

    public void setCartId(Cart cartId) {
        this.cart = cartId;
    }

    public Product getProductId() {
        return product;
    }

    public void setProductId(Product product) {
        this.product = product;
    }

}
