package com.softwears.Softwear.Orders;

import java.time.LocalDateTime;
import java.util.Date;

import com.softwears.Softwear.Users.Users;

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
@Table(name = "orders") /* set for data integrity */
public class Orders {
    /*@Columns are set for data integrity */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "order_date") 
    private LocalDateTime orderDate;

    @Column(name = "order_status") 
    private String orderStatus;

    @Column(name = "order_price")
    private double orderPrice;

    @ManyToOne /*changed to ManytoOne, to allow users to have multiple orders */
    @JoinColumn(name = "fkey_customer_id")
    private Users customerId;

    public Orders() {}

    public Orders(Users customerId){
        this.customerId = customerId;
        this.orderDate = LocalDateTime.now();
    }

    public Orders(LocalDateTime orderDate, String orderStatus, double orderPrice, Users customerId){
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderPrice = orderPrice;
        this.customerId = customerId;
    } 

    /* Getters & Setters */

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Users getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Users customerId) {
        this.customerId = customerId;
    }

}
