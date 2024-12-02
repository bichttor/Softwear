package com.softwears.Softwear.Payments;

import com.softwears.Softwear.Users.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_details")
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentDetailsId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "cvv")
    private double cvv;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "card_function")
    private String cardFunction;

    @Column(name = "bank")
    private String bank;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Users customerId;

    public PaymentDetails() {}

    public PaymentDetails(String cardNumber, String cardName, String expirationDate, double cvv, String cardType, String cardFunction, String bank, Users customerId) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.cardType = cardType;
        this.cardFunction = cardFunction;
        this.bank = bank;
        this.customerId = customerId;

    }

    public void setPaymentDetailsId(int paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    public int getPaymentDetailsId() {
        return paymentDetailsId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getCVV() {
        return cvv;
    }

    public void setCVV(double cvv) {
        this.cvv = cvv;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardFunction() {
        return cardFunction;
    }

    public void setCardFunction(String cardFunction) {
        this.cardFunction = cardFunction;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Users getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Users customerId) {
        this.customerId = customerId;
    }
}