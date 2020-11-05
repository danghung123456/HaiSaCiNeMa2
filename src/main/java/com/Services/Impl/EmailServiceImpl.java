package com.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
    private JavaMailSender emailSender;

	@Override
	public void sendMail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("HaiSaCinema@gmail.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
	}
}
