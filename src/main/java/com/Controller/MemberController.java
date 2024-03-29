package com.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DTO.MemberDTO;
import com.Entity.Member;
import com.Entity.Movie;
import com.Entity.Role;
import com.Entity.User;
import com.Entity.UserRole;
import com.Services.EmailService;
import com.Services.MemberService;
import com.Services.RoleService;
import com.Services.UserRoleService;
import com.Services.UserService;
import com.Constant.*;
import com.DTO.Base.ResponseEntity;

@RestController
@RequestMapping(value = "member")

public class MemberController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberService memberService;
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;

	@GetMapping
	public ResponseEntity<List<Member>> index() {
		return ResponseEntity.body(memberService.getAll());
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addMember(@RequestBody MemberDTO memberDTO) {
		Optional<User> checkUser = userService.findByEmail(memberDTO.getEmail());
		if (checkUser.isPresent()) {
			return ResponseEntity.body(Constant.Exception.MESSAGE);
		}
		if (memberDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			User user = new User();
			user.setEmail(memberDTO.getEmail());
			UUID uuid = UUID.randomUUID();
			String password = passwordEncoder.encode(uuid.toString());
			user.setPassword(password);
			// chưa bắt trường hợp sai email
			emailService.sendMail(user.getEmail(), "Đăng kí thành công", "Mật khẩu của quý khách là :" + uuid,null);
			user = userService.add(user);
			UserRole userRole = new UserRole();
			userRole.setRole(roleService.findById(2));
			userRole.setUser(user);
			userRoleService.add(userRole);
			memberDTO.setMemberId(null);
			Member member = memberService.convertToMember(memberDTO);
			member.setUser(user);
			return ResponseEntity.body(memberService.add(member));
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Object> updateMember(@RequestBody MemberDTO memberDTO) {
		if (memberDTO.isNull(true)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Member> checkMember = memberService.findById(memberDTO.getMemberId());
			if (checkMember.isPresent()) {
				User user = checkMember.orElse(null).getUser();
				String password = passwordEncoder.encode(memberDTO.getPassword());
				user.setPassword(password);
				user = userService.update(user);
				Member member = memberService.convertToMember(memberDTO);
				member.setUser(user);
				member = memberService.save(member);
				return ResponseEntity.body(memberService.save(member));
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@GetMapping("/findbyid")
	public ResponseEntity<Object> findById(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Member> optionalMember = memberService.findById(id);
			if (optionalMember.isPresent()) {
				Member member = optionalMember.orElse(null);
				return ResponseEntity.body(member);
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@GetMapping("/findbyname")
	public ResponseEntity<Object> findByName(String name) {
		if (name == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			List<Member> listMember = memberService.findByName(name);
			if (listMember.isEmpty()) {
				return ResponseEntity.body(Constant.NOT_FOUND);
			} else {
				return ResponseEntity.body(listMember);
			}
		}
	}

}
