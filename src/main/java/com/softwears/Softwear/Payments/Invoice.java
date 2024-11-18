package com.softwears.Softwear.Payments;

import com.softwears.Softwear.Orders.Orders;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;

    @Column(name = "invoice_cost")
    private String invoiceCost;

    @Column(name = "invoice_date")
    private String invoiceDate;

    @Column(name = "invoice_status")
    private String invoiceStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Orders orderId;

    public Invoice() {
    }

    public Invoice(String cost, String date, String status) {
        this.invoiceCost = cost;
        this.invoiceDate = date;
        this.invoiceStatus = status;

    }

    public void setInvoiceId(int invoice) {
        this.invoiceId = invoice;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public String getCost() {
        return invoiceCost;
    }

    public String getDate() {
        return invoiceDate;
    }

    public String getStatus() {
        return invoiceStatus;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

}
