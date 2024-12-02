package com.softwears.Softwear.Payments;

import java.time.LocalDateTime;

import com.softwears.Softwear.Orders.Orders;
import com.softwears.Softwear.Users.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;

    @Column(name = "invoice_cost")
    private double invoiceCost;

    @Column(name = "invoice_date")
    private LocalDateTime invoiceDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Users customerId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders orderId;

    public Invoice() {
    }

    public Invoice(double invoiceCost, LocalDateTime date, Users customerId) {
        this.invoiceCost = invoiceCost;
        this.invoiceDate = date;
        this.customerId = customerId;

    }

    public void setInvoiceId(int invoice) {
        this.invoiceId = invoice;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public double getCost() {
        return invoiceCost;
    }

    public void setCost(double invoiceCost) {
        this.invoiceCost = invoiceCost;
    }

    public LocalDateTime getDate() {
        return invoiceDate;
    }

    public void setDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Users getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Users customerId) {
        this.customerId = customerId;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

}
