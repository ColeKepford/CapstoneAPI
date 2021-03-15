package com.HailMaryAPI.HailMary.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class SendEmailService  {

    @Autowired
    private JavaMailSender sendMail;

    public void sendEmail(Email email) {

        String html = "<!doctype html>\n" +
        "<head>\n" +
        "    <meta charset=\"UTF-8\">\n" +
        "    <meta name=\"viewport\"\n" +
        "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
        "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
        "    <title>" + email.getTopic() + "</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<div>Email from:<b>" + email.getFrom() + "</b></div>\n" +
        "\n" +
        "<div>" + email.getBody() + "</div>\n" +
        "</body>\n" +
        "</html>\n";

        System.out.println("sending email...");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nexgenfinancialinsurance@gmail.com");
        message.setTo("nexgenfinancialinsurance@gmail.com");
        message.setSubject("Email from: " + email.getFrom());
        message.setText(html);
        sendMail.send(message);
        System.out.println("sent email...");
    }
}
    
