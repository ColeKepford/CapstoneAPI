package com.HailMaryAPI.HailMary.Admin;

import javax.persistence.*;

@Entity
@Table(name="ngf_administrators")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;
    private Integer role;
    private String email;
    private String first_name;
    private String last_name;
    private String password;
    

    public Admin() {
    }

    public Admin(Integer employee_id, Integer role, String email, String first_name, String last_name,
            String password) {
        this.employee_id = employee_id;
        this.role = role;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }


    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }


    public Integer getRole() {
        return role;
    }


    public void setRole(Integer role) {
        this.role = role;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getFirst_name() {
        return first_name;
    }


    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public String getLast_name() {
        return last_name;
    }


    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin [email=" + email + 
        ", employee_id=" + employee_id + 
        ", first_name=" + first_name + 
        ", last_name=" + last_name + 
        ", password=" + password + 
        ", role=" + role + "]";
    }

   
}

