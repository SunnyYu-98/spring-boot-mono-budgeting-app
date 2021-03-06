package com.cashu.budgetapp.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


@Service("emailService")
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String recipient, String emailSubject, String emailBody) {

        final String username = "cashubudgeting@gmail.com";
        final String password = "cashuDBU2019";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("cashubudgeting@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            message.setSubject(emailSubject);
            message.setText(emailBody, "utf-8", "html");

            Transport.send(message);

            System.out.println("Email sent to " + recipient);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}