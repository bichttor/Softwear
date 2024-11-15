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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Orders orderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product productId;

    public OrderItems() {}

    public OrderItems(int orderPrice, int orderCount, Orders orderId, Product productId){
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

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderID(Orders orderId) {
        this.orderId = orderId;
    }

    public Product getProductID() {
        return productId;
    }

    public void setProductID(Product productId) {
        this.productId = productId;
    }

}
