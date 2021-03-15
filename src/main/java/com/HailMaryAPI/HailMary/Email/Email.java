package com.HailMaryAPI.HailMary.Email;

public class Email {
    private String to = "nexgenfinancialinsurance@gmail.com";
    private String from;
    private String body;
    private String topic;

    public Email(String from, String body, String topic) {
        this.from = from;
        this.body = body;
        this.topic = topic;
    }

    public String getTo() {
        return this.to;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getFrom() {
        return this.from;
    }
    
}
