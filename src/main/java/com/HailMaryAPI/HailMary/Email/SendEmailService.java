package com.HailMaryAPI.HailMary.Email;

import com.HailMaryAPI.HailMary.Logging.LoggingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;

@Component
public class SendEmailService {

    @Autowired
    private JavaMailSender sendMail;
    private LoggingController logs;

    public void sendEmail(Email email) {
        boolean sent;
        String nexgen = "nexgenfinancialinsurance@gmail.com";
        this.logs.sendingEmail();
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            String body = email.getName() + " has contacted you about: " + email.getTopic();
            message.setFrom(nexgen);
            message.setTo(nexgen);
            message.setSubject("Email from: " + email.getFrom());
            message.setText(body);
            sendMail.send(message);
            this.logs.emailSent();
            sent = true;
        } catch(Exception e) {
            this.logs.unableToSendEmail("Error code 1.");
            sent = false;
        }
        if(sent) {
                try{
                SimpleMailMessage message = new SimpleMailMessage();
                String response = "Thank you for contacting NexGen insurance! \n" + 
                                    "We have successfully received your email, please remain" +
                                    " patient while we get back to you";
                message.setFrom(nexgen);
                message.setTo(email.getFrom());
                message.setSubject("Email received");
                message.setText(response);
                sendMail.send(message);
            } catch (Exception e) {
                this.logs.unableToSendEmail("Error code 2.");
            }
        }
    }
}
    
