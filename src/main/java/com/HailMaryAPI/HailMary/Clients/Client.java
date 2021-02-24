package com.HailMaryAPI.HailMary.Clients;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="ngf_clients")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer client_id;
    private String country;
    @Column(name="date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private String email;
    private String first_name;
    private String last_name;
    private String password;
    private Long phone_number;
    private String postal_code;
    @Column(name="province")
    private String prov;

    private String street_address;

    public Client() {
    }

    public Client(String email, String first_name, String last_name, LocalDate dob, Long phone_number,
                  String street_address, String prov, String country, String postal_code,
                  String password) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.phone_number = phone_number;
        this.street_address = street_address;
        this.prov = prov;
        this.country = country;
        this.postal_code = postal_code;
        this.password = password;
    }

    public Client(Integer client_id, String email, String first_name, String last_name, LocalDate dob,
                  Long phone_number, String street_address, String prov, String country, String postal_code,
                  String password) {
        this.client_id = client_id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.phone_number = phone_number;
        this.street_address = street_address;
        this.prov = prov;
        this.country = country;
        this.postal_code = postal_code;
        this.password = password;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getClient_id() {
        return client_id;
    }

    @Override
    public String toString() {
        return "ngf_clients{" +
                "id=" + client_id +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob=" + dob +
                ", phone_number=" + phone_number +
                ", street_address='" + street_address + '\'' +
                ", prov='" + prov + '\'' +
                ", country='" + country + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

