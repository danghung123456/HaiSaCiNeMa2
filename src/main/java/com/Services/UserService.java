package com.Services;

import com.Entity.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	User add(User user);
	
	User update(User user);
}
