package com.Services;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
	
	public void sendMail(String to, String subject, String text);
	
}
