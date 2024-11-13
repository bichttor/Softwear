package com.softwears.Softwear.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer") /* set for data integrity */
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int    id;

    @Column(name = "customer_fname") 
    private String customerFname;

    @Column(name = "customer_lname") 
    private String customerLname;

    @Column(name = "customer_email") 
    private String customerEmail;

    @Column(name = "customer_password") 
    private String customerPassword;

    @Column(name = "customer_phone") 
    private String customerPhone;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
    
    public Customer(){}
    public Customer(String customerFname, String customerLname, String customerEmail, String customerPhone, String customerPassword, Address address){
        this.customerFname = customerFname;
        this.customerLname = customerLname;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerPassword = customerPassword;
        this.address = address;
    }
    public void setId(int id){
        this.id = id;
    }
    /*Getters */
    public int getId(){
        return id;
    }
    public String getcustomerFname(){
        return this.customerFname;
    }
    public String getcustomerLname(){
        return this.customerLname;
    }
    public String getcustomerEmail(){
        return this.customerEmail;
    }
    public String getcustomerPhone(){
        return this.customerPhone;
    }
    public String getcustomerPassword(){
        return this.customerPassword;
    }
    public Address getAddress(){
        return this.address;
    }
}
