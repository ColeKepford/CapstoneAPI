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
        boolean sent;
        System.out.println("sending email...");
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            String body = email.getName() + " has contacted you about: " + email.getTopic();
            message.setFrom("nexgenfinancialinsurance@gmail.com");
            message.setTo("nexgenfinancialinsurance@gmail.com");
            message.setSubject("Email from: " + email.getFrom());
            message.setText(body);
            sendMail.send(message);
            System.out.println("Email sent successfully");
            sent = true;
        } catch(Exception e) {
            System.out.println("Unable to send email");
            sent = false;
        }
        if(sent) {
            System.out.println("sending response email...");
                try{
                SimpleMailMessage message = new SimpleMailMessage();
                String response = "Thank you for contacting NexGen insruance! \n" + 
                                    "We have successfully recieved your email, please remain" +
                                    " patient while we get back to you";
                message.setFrom("nexgenfinancialinsurance@gmail.com");
                message.setTo(email.getTo());
                message.setSubject("Email recieved");
                message.setText(response);
                sendMail.send(message);
            } catch (Exception e) {
                System.out.println("Unable to send response email...");
            }
        }
    }
}
    
