package com.vico.LeaveManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendMessage(String toMail, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("lms.vico@gmail.com");
        message.setTo(toMail);
        message.setSubject(subject);
        message.setText(text);
    }


}
