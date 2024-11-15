package com.softwears.Softwear.Orders;

import com.softwears.Softwear.Users.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/*Using the Entity tag creates a table with the values given so no schema will have to be written 
 * You can essentially copy and paste this file for other data and just change the respective values
*/

@Entity
@Table(name = "cart") /* set for data integrity */
public class Cart {
    /*@Columns are set for data integrity */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "cart_price") 
    private double cartPrice;

    @Column(name = "cart_count") 
    private int cartCount;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)   
    private final Users customerID;

    @Column(name = "order_id")
    private int orderID;

    public Cart(Users customerID){
        this.customerID = customerID;
        this.cartPrice = 0.00;
        this.cartCount = 0;
    }

    public Cart(Users customerID, double cartPrice, int cartCount){
        this.customerID = customerID;
        this.cartPrice = cartPrice;
        this.cartCount = cartCount;
    } 

    public Cart(Users customerID, double cartPrice, int cartCount, int orderID){
        this.customerID = customerID;
        this.cartPrice = cartPrice;
        this.cartCount = cartCount;
        this.orderID = orderID;
    }



    /* Getters & Setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Users getCustomerID() {
        return customerID;
    }
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

}
