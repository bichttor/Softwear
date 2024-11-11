package com.softwears.Softwear.Payments;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "payment_date")
    private String paymentDate;

    @Column(name = "payment_transaction_id")
    private String transactionId;

    @Column(name = "payment_amount")
    private double paymentAmount;

    @Column(name = "invoice_id")
    private int invoiceId;

    public Payment() {}

    public Payment(String type, String date, String transaction, double amount, int invoice) {
        this.paymentType = type;
        this.paymentDate = date;
        this.transactionId = transaction;
        this.paymentAmount = amount;
        this.invoiceId = invoice;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public String getType() {
        return paymentType;
    }

    public String getDate() {
        return paymentDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return paymentAmount;
    }

    public int getInvoiceId() {
        return invoiceId;
    }
}