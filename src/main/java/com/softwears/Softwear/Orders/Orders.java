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
@Table(name = "orders") /* set for data integrity */
public class Orders {
    /*@Columns are set for data integrity */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "order_date") 
    private String orderDate;

    @Column(name = "order_status") 
    private int orderStatus;

    @Column(name = "order_price")
    private int orderPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkey_customer_id")
    //@Column(name = "customer_id")
    private Customer customerId;

    public Orders() {}

    public Orders(String orderDate, int orderStatus, int orderPrice, Customer customerId){
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

}
