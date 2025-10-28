package com.sahil.Public.Road.Transparency.Accountability.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendComplaintNotification(String toEmail, String name, String roadName, String location, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject("New Road Complaint Received");
        mailMessage.setText(
                "New complaint submitted:\n\n" +
                        "Name: " + name + "\n" +
                        "Road: " + roadName + "\n" +
                        "Location: " + location + "\n" +
                        "Message: " + message + "\n\n" +
                        "Please take appropriate action."
        );

        mailSender.send(mailMessage);
    }
}