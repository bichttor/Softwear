package com.softwears.Softwear.Orders;

import com.softwears.Softwear.Users.Customer;

import jakarta.persistence.CascadeType;
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
    private int cartId;

    @Column(name = "cart_price") 
    private double cartPrice;

    @Column(name = "cart_count") 
    private int cartCount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customerID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Orders orderID;

    public Cart(Customer customerID){
        this.customerID = customerID;
        this.cartPrice = 0.00;
        this.cartCount = 0;
    }

    public Cart(Customer customerID, double cartPrice, int cartCount){
        this.customerID = customerID;
        this.cartPrice = cartPrice;
        this.cartCount = cartCount;
    } 

    public Cart(Customer customerID, double cartPrice, int cartCount, Orders orderID){
        this.customerID = customerID;
        this.cartPrice = cartPrice;
        this.cartCount = cartCount;
        this.orderID = orderID;
    }



    /* Getters & Setters */

    public int getId() {
        return cartId;
    }

    public void setId(int cartId) {
        this.cartId = cartId;
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

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public Orders getOrderID() {
        return orderID;
    }

    public void setOrderID(Orders orderID) {
        this.orderID = orderID;
    }

}
