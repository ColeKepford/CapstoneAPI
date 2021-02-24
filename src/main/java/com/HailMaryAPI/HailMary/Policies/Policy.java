package com.HailMaryAPI.HailMary.Policies;

import java.time.LocalDate;

import javax.persistence.*;

import com.HailMaryAPI.HailMary.Clients.Client;

@Entity
@Table(name = "ngf_policies")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policy_id;
    
    @JoinColumn(name = "client", referencedColumnName = "client_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Client client;
    @Column(name="policy_number")
    private String policyNumber;
    private String first_name;
    private String last_name;
    private String provider;
    private String type;
    private double coverage_amount;
    private LocalDate start_date;
    private LocalDate end_date;

    public Policy () {

    }

    public Policy(Client client, String policyNumber, String first_name, String last_name, String provider, String type, double coverage_amount, LocalDate start_date, LocalDate end_date) {
        this.client = client;
        this.policyNumber = policyNumber;
        this.first_name = first_name;
        this.last_name = last_name;
        this.provider = provider;
        this.type = type;
        this.coverage_amount = coverage_amount;
        this.start_date = start_date;
        this.end_date = end_date;
    }


    public Policy(int policy_id, Client client, String policyNumber, String first_name, String last_name, String provider, String type, double coverage_amount, LocalDate start_date, LocalDate end_date) {
        this.policy_id = policy_id;
        this.client = client;
        this.policyNumber = policyNumber;
        this.first_name = first_name;
        this.last_name = last_name;
        this.provider = provider;
        this.type = type;
        this.coverage_amount = coverage_amount;
        this.start_date = start_date;
        this.end_date = end_date;
    }


    public int getPolicy_id() {
        return this.policy_id;
    }

    public void setPolicy_id(int policy_id) {
        this.policy_id = policy_id;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPolicyNumber() {
        return this.policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCoverage_amount() {
        return this.coverage_amount;
    }

    public void setCoverage_amount(double coverage_amount) {
        this.coverage_amount = coverage_amount;
    }

    public LocalDate getStart_date() {
        return this.start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
    
    @Override
    public String toString() {
        return "{" +
            " policy_id='" + getPolicy_id() + "'" +
            ", client='" + getClient() + "'" +
            ", policyNum='" + getPolicyNumber() + "'" +
            ", first_name='" + getFirst_name() + "'" +
            ", last_name='" + getLast_name() + "'" +
            ", provider='" + getProvider() + "'" +
            ", type='" + getType() + "'" +
            ", coverage_amount='" + getCoverage_amount() + "'" +
            ", start_date='" + getStart_date() + "'" +
            ", end_date='" + getEnd_date() + "'" +
            "}";
    }


    
}
