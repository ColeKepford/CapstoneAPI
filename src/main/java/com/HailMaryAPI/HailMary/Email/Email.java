package com.HailMaryAPI.HailMary.Email;

public class Email {
    private String to = "nexgenfinancialinsurance@gmail.com";
    private String from;
    private String body;
    private String topic;
    private String name;

    public Email(String from, String name, String body, String topic) {
        this.from = from;
        this.name = name;
        this.body = body;
        this.topic = topic;
    }

    public String getTo() {
        return this.to;
    }

    public String getBody() {
        return this.body;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getFrom() {
        return this.from;
    }

    public String getName() {
        return name;
    }


    
    
}
