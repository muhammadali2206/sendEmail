package com.example.sendemail;

import com.example.sendemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SendEmailApplication {
    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(SendEmailApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() throws MessagingException {
        emailService.sendEmail("toEmail@gmail.com",
                "This is email body",
                "This is email subject");

    }
}
