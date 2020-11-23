package com.Controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.ChangePasswordDTO;
import com.Entity.User;
import com.Services.UserService;

@RestController
public class AuthenController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(AuthenController.class);

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, Object> payload) {
		logger.info("payload={}", payload);
		return ResponseEntity.ok(true);
	}

	@PostMapping("/changepassword")
	public ResponseEntity<?> changePass(@RequestBody ChangePasswordDTO changePassDTO) {
		User user = userService.getUserByEmail(changePassDTO.getEmail());
		String oldPassword = changePassDTO.getOldPassword();
		String oldPasswordDb = user.getPassword();
		String newPassword = passwordEncoder.encode(changePassDTO.getNewPassword());		
		if (BCrypt.checkpw(oldPassword, oldPasswordDb)) {
			user.setPassword(newPassword);
			userService.update(user);
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.ok(false);
		}
	}

}
