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
@Table(name = "users") /* set for data integrity */
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int    id;

    @Column(name = "user_fname") 
    private String userFname;

    @Column(name = "user_lname") 
    private String userLname;

    @Column(name = "user_email") 
    private String userEmail;

    @Column(name = "user_password") 
    private String userPassword;

    @Column(name = "user_phone") 
    private String userPhone;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "user_role") 
    private String userRole;

    public Users(){}
    public Users(String userFname, String userLname, String userEmail, String userPhone,String userPasssword, String userRole, Address address){
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
        this.userPassword = userPasssword;
        this.userPhone = userPhone;
        this.address = address;
        this.userRole = userRole;
       
    }
    public void setId(int id){
        this.id = id;
    }
    /*Setters */
    public void setUserPassword(String password){
        this.userPassword = password;
    }
    public void setUserEmail(String email){
        this.userEmail = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    /*Getters */
    public int getId(){
        return id;
    }
    public String getuserFname(){
        return this.userFname;
    }
    public String getuserLname(){
        return this.userLname;
    }
    public String getuserEmail(){
        return this.userEmail;
    }
    public String getuserPhone(){
        return this.userPhone;
    }
    public String getuserRole(){
        return this.userRole;
    }
    public String getuserPassword(){
        return this.userPassword;
    }
    public Address getAddress(){
        return this.address;
    }
}
