package com.Controller;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.ChangePasswordDTO;
import com.DTO.Base.ResponseEntity;
import com.Entity.User;
import com.Services.EmailService;
import com.Services.UserService;
import com.Services.ViewService;

@RestController
public class AuthenController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private ViewService viewService;
	

	@PostMapping(value ="/login")
	public ResponseEntity<?> login(@RequestBody Map<String, Object> payload) {
		Set<String> set = payload.keySet();
		String email = null;
		for(String key:set) {
			email = (String) payload.get(key);
		}
		return ResponseEntity.body(viewService.getRole(email));

	}

	@PostMapping(value = "/changepassword")
	public ResponseEntity<Object> changePass(@RequestBody ChangePasswordDTO changePassDTO) {
		Optional<User> checkEmail = userService.checkUserByEmail(changePassDTO.getEmail());
		if (checkEmail.isPresent()) {
			User user = userService.getUserByEmail(changePassDTO.getEmail());
			String oldPassword = changePassDTO.getOldPassword();
			String oldPasswordDb = user.getPassword();
			String newPassword = passwordEncoder.encode(changePassDTO.getNewPassword());
			if (BCrypt.checkpw(oldPassword, oldPasswordDb)) {
				user.setPassword(newPassword);
				userService.update(user);
				return ResponseEntity.body(Constant.SUCCESS);
			} else {
				return ResponseEntity.body(Constant.UNEXPECTED_ERR);
			}
		} else {
			return ResponseEntity.body(Constant.NOT_FOUND);
		}
	}

	@PostMapping(value ="/forgotpassword")
	public ResponseEntity<?> forgotPass(@RequestBody ChangePasswordDTO changePassDTO) {
		Optional<User> checkEmail = userService.checkUserByEmail(changePassDTO.getEmail());
		if (checkEmail.isPresent()) {
			User user = userService.getUserByEmail(changePassDTO.getEmail());
			UUID uuid = UUID.randomUUID();
			String code = uuid.toString().substring(0, 8);
			String newPassword = passwordEncoder.encode(code);
			user.setPassword(newPassword);
			userService.update(user);
			try {
				emailService.sendMail(user.getEmail(), "Đổi mật khẩu thành công", "Mật khẩu của quý khách là :" + code, null);
			} catch (Exception e) {
				return ResponseEntity.body(Constant.ERR);
			}
			return ResponseEntity.body(Constant.SUCCESS);
		} else {
			return ResponseEntity.body(Constant.NOT_FOUND);
		}
	}
}
