package com.softwears.Softwear.Orders;


import com.softwears.Softwear.Users.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)   
    private Users customerID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Orders orderId;

    
    public Cart() {}

    public Cart(Users customerID, Orders orderId){
        this.customerID = customerID;
        this.orderId = orderId;
        this.cartPrice = 0.00;
        this.cartCount = 0;
    }

    public Cart(Users customerID, double cartPrice, int cartCount){
        this.customerID = customerID;
        this.cartPrice = cartPrice;
        this.cartCount = cartCount;
    } 

    public Cart(Users customerID, double cartPrice, int cartCount, Orders orderId){
        this.customerID = customerID;
        this.cartPrice = cartPrice;
        this.cartCount = cartCount;
        this.orderId = orderId;
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

    public Users getCustomerID() {
        return customerID;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }
    
}
