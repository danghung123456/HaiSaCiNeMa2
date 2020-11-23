package com.Services;

import com.Entity.User;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	User add(User user);
	
	User update(User user);
	
	User getUserByEmail(String email);
	
	Optional<User> findByEmail(String email);
}
