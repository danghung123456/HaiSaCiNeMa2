package com.Services;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Multipart;

<<<<<<< HEAD
import org.springframework.mail.SimpleMailMessage;
=======
>>>>>>> c663371e62c400b0b231c3987c4c9835e3e5b565
import org.springframework.stereotype.Service;

import com.Entity.Ticket;

@Service
public interface EmailService {

<<<<<<< HEAD
	void sendMail(String to, String subject,String text, Multipart mp);
=======
	void sendMail(String to, String subject, String text, Multipart mp);
	
	Multipart setTextTicket(Ticket ticket, String filePath) throws IOException, MessagingException;
>>>>>>> c663371e62c400b0b231c3987c4c9835e3e5b565
	
	Multipart setTextTicket(Ticket ticket, String filePath) throws IOException, MessagingException;
}
