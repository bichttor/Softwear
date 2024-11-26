package com.softwears.Softwear.Payments;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "discounts")
public class Discounts {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discountId;

    @Column(name = "discount_code")
    private String discountCode;

    @Column(name = "discount_amount")
    private double discountAmount; /* shown as decimal e.g 2.0 = 20% */

    @Column(name = "discount_applicable")
    private String discountApplicable; /* What the discount can be applied to */

    public Discounts(){};

    public Discounts(String discountCode, double discountAmount, String discountApplicable){
        this.discountCode = discountCode;
        this.discountAmount = discountAmount;
        this.discountApplicable = discountApplicable;
    }

    /*Getters */
    public int getDiscountId(){
        return discountId;
    }
    public String getDiscountCode(){
        return discountCode;
    }
    public String getDiscountApplicable(){
        return discountApplicable;
    }
    public double getDiscountAmount(){
        return discountAmount;
    }
    /*Setters */
    public void setDiscountCode(String discountCode){
        this.discountCode = discountCode;
    }
    public void setDiscountApplicable(String discountApplicable){
        this.discountApplicable = discountApplicable;
    }
    public void setDiscountAmount(double discountAmount){   
        this.discountAmount = discountAmount;
    }
}
