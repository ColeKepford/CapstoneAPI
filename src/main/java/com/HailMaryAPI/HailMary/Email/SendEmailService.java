package com.HailMaryAPI.HailMary.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;

@Component
public class SendEmailService {

    @Autowired
    private JavaMailSender sendMail;

    public void sendEmail(Email email) {

        String body = email.getName() + " has contacted you about: " + email.getTopic();
        System.out.println("sending email...");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nexgenfinancialinsurance@gmail.com");
        message.setTo("nexgenfinancialinsurance@gmail.com");
        message.setSubject("Email from: " + email.getFrom());
        message.setText(body);
        sendMail.send(message);
        System.out.println("sent email...");
    }
}
    
