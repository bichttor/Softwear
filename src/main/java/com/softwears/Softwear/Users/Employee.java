package com.softwears.Softwear.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee") /* set for data integrity */
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int    id;
    @Column(name = "employee_fname") 
    private String employeeFname;

    @Column(name = "employee_lname") 
    private String employeeLname;

    @Column(name = "employee_email") 
    private String employeeEmail;

    @Column(name = "employee_phone") 
    private String employeePhone;

    @Column(name = "employee_role") 
    private String employeeRole;

    public Employee(){}
    public Employee(String employeeFname, String employeeLname, String employeeEmail, String employeePhone, String employeeRole){
        this.employeeFname = employeeFname;
        this.employeeLname = employeeLname;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.employeeRole = employeeRole;
    }
    public void setId(int id){
        this.id = id;
    }
    /*Getters */
    public int getId(){
        return id;
    }
    public String getemployeeFname(){
        return this.employeeFname;
    }
    public String getemployeeLname(){
        return this.employeeLname;
    }
    public String getemployeeEmail(){
        return this.employeeEmail;
    }
    public String getemployeePhone(){
        return this.employeePhone;
    }
    public String getemployeeRole(){
        return this.employeeRole;
    }
}
