package com.softwears.Softwear.Orders;

import com.softwears.Softwear.Products.Product;

import jakarta.persistence.CascadeType;
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
    private int cartItemsId;

    @Column(name = "cart_item_price") 
    private double cartPrice;

    @Column(name = "cart_item_count") 
    private int cartCount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cartId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product productId;

    public CartItem() {}

    public CartItem(int cartPrice, int cartCount, Cart cartId, Product productId){
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

    public Cart getCartID() {
        return cartId;
    }

    public void setCartID(Cart cartId) {
        this.cartId = cartId;
    }

    public Product getProductID() {
        return productId;
    }

    public void setProductID(Product productId) {
        this.productId = productId;
    }

}
