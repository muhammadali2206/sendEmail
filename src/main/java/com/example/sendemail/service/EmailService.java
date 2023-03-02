package com.example.sendemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${email}")
    private String email;
    public void sendEmail(String toEmail,
                                String subject,
                                String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email);
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);

    }

}
