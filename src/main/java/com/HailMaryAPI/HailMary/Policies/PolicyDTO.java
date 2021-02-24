package com.HailMaryAPI.HailMary.Policies;

public class PolicyDTO {
    private int id;
    private String last_name;

    public PolicyDTO() {

    }
    
    public PolicyDTO(int id, String last_name) {
        this.id = id;
        this.last_name = last_name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    
}
