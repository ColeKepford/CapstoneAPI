package com.HailMaryAPI.HailMary.Summary;

import javax.persistence.*;

import com.HailMaryAPI.HailMary.Clients.Client;

@Entity
@Table(name="ngf_summaries")
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer summary_id;
    @JoinColumn(name = "client")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Client client;
    private String path;

    public Summary() {
    }

    public Summary(Integer summary_id, Client client, String path) {
        this.summary_id = summary_id;
        this.client = client;
        this.path = path;
    }

    public Integer getSummary_id() {
        return summary_id;
    }

    public void setSummary_id(Integer summary_id) {
        this.summary_id = summary_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    
}

