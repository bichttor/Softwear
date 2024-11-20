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
    public Users(String userFname, String userLname, String userEmail, String userPhone,String userPassword, String userRole, Address address){
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
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
    public String getUserFname(){
        return userFname;
    }
    public String getUserLname(){
        return userLname;
    }
    public String getUserEmail(){
        return userEmail;
    }
    public String getUserPhone(){
        return userPhone;
    }
    public String getUserRole(){
        return userRole;
    }
    public String getUserPassword(){
        return userPassword;
    }
    public Address getAddress(){
        return address;
    }
}
