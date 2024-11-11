package com.softwears.Softwear.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")/* set for data integrity */
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int    id;

    @Column(name = "address_street") 
    private String addressStreet;

    @Column(name = "address_city") 
    private String addressCity;
    
    @Column(name = "address_state") 
    private String addressState;
    
    @Column(name = "address_zip") 
    private int addressZip;

    @Column(name = "address_country") 
    private String addressCountry;

    public Address(){}
    public Address(String addressStreet, String addressCity, String addressState, int addressZip, String addressCountry){
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.addressZip = addressZip;
        this.addressCountry = addressCountry;
    }

    public void setId(int id){
        this.id = id;
    }
    /*Getters */
    public int getId(){
        return id;
    }

    public String getaddressStreet(){
        return this.addressStreet;
    }

    public String getaddressCity(){
        return this.addressCity;
    }

    public String getaddressState(){
        return this.addressState;
    }

    public int getaddressZip(){
        return this.addressZip;
    }

    public String getaddressCountry(){
        return this.addressCountry;
    }

}
