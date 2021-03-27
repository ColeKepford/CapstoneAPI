package com.HailMaryAPI.HailMary.Summary;

import javax.persistence.*;

@Entity
@Table(name="ngf_summaries")
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer summary_id;
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Integer client_id;
    private String path;

    public Summary() {
    }

    public Summary(Integer summary_id, Integer client_id, String path) {
        this.summary_id = summary_id;
        this.client_id = client_id;
        this.path = path;
    }

    public Integer getSummary_id() {
        return summary_id;
    }

    public void setSummary_id(Integer summary_id) {
        this.summary_id = summary_id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    
}

