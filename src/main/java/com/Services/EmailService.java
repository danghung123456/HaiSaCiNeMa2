package com.Services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.Entity.Ticket;

@Service
public interface EmailService {

	void sendMail(String to, String subject, Ticket ticket, String filePath);
	
}
