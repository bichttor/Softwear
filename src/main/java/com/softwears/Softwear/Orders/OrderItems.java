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
@Table(name = "order_items") /* set for data integrity */
public class OrderItems {
    /*@Columns are set for data integrity */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int orderItemsId;

    @Column(name = "order_item_price") 
    private double orderPrice;

    @Column(name = "order_item_count") 
    private int orderCount;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_id")
    private int productId;

    public OrderItems() {}

    public OrderItems(int orderPrice, int orderCount, int orderId, int productId){
        this.orderPrice = orderPrice;
        this.orderCount = orderCount;
        this.orderId = orderId;
        this.productId = productId;
    } 

    /* Getters & Setters */

    public int getCartItemsId() {
        return orderItemsId;
    }

    public void setCartItemsId(int orderItemsId) {
        this.orderItemsId = orderItemsId;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderID(int orderId) {
        this.orderId = orderId;
    }

    public int getProductID() {
        return productId;
    }

    public void setProductID(int productId) {
        this.productId = productId;
    }

}
