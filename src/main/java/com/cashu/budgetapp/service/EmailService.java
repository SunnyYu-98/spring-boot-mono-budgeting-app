package com.cashu.budgetapp.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


public class EmailService {
    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("austincsoles21@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n This is a test");


        JavaMailSender javaMailSender = new JavaMailSenderImpl();
        javaMailSender.send(msg);

    }

}
