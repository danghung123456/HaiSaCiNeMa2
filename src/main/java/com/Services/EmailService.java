package com.Services;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.Entity.Ticket;

@Service
public interface EmailService {

	void sendMail(String to, String subject,String text, Multipart mp) throws Exception;
	
	Multipart setTextTicket(Ticket ticket, String filePath) throws IOException, MessagingException;
}
