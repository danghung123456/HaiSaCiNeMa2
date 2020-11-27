package com.Controller;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.ChangePasswordDTO;
import com.Entity.User;
import com.Repository.UserRepository;
import com.Repository.ViewRepository;
import com.Services.EmailService;
import com.Services.UserService;
import com.Services.Impl.UserPrinciple;
import com.Services.Impl.UserServiceImpl;

@RestController
public class AuthenController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
	@Autowired
	UserRepository repository;
	@Autowired
	UserServiceImpl userServie;
	@Autowired
	ViewRepository viewrepo;
	private static final Logger logger = LoggerFactory.getLogger(AuthenController.class);

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, Object> payload) {
		logger.info("payload={}", payload.values());
		Set<String> set = payload.keySet();
		String getRoleName = null;
		for(String key:set) {
			getRoleName = (String) payload.get(key);
		}
		return ResponseEntity.ok(viewrepo.getRole(getRoleName));

	}

	
	
	
	@PostMapping("/changepassword")
	public ResponseEntity<?> changePass(@RequestBody ChangePasswordDTO changePassDTO) {
		Optional<User> checkEmail = userService.checkUserByEmail(changePassDTO.getEmail());
		if (checkEmail.isPresent()) {
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
		} else {
			return ResponseEntity.ok(false);
		}
	}

	@PostMapping("/forgotpassword")
	public ResponseEntity<?> forgotPass(@RequestBody ChangePasswordDTO changePassDTO) {
		Optional<User> checkEmail = userService.checkUserByEmail(changePassDTO.getEmail());
		if (checkEmail.isPresent()) {
			User user = userService.getUserByEmail(changePassDTO.getEmail());
			UUID uuid = UUID.randomUUID();
			String newPassword = passwordEncoder.encode(uuid.toString());
			user.setPassword(newPassword);
			userService.update(user);
			emailService.sendMail(user.getEmail(), "Đổi mật khẩu thành công", "Mật khẩu của quý khách là :" + uuid,
					null);
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.ok(false);
		}
	}
}
