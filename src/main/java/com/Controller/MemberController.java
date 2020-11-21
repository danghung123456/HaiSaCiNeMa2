package com.Controller;

import java.util.List;
import java.util.Optional;

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
import com.Entity.User;
import com.Services.MemberService;
import com.Services.UserService;
import com.Constant.*;
import com.DTO.Base.ResponseEntity;

@RestController
@RequestMapping(value = "member")

public class MemberController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberService memberService;
	@Autowired
	private UserService userService;
	@GetMapping

	public ResponseEntity<List<Member>> index() {
		return ResponseEntity.body(memberService.getAll());
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addMember(@RequestBody MemberDTO memberDTO) {
		if (memberDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			// Make sure id is NULL to insert Entity
			User user = new User();
			user.setEmail(memberDTO.getEmail());
			String password = passwordEncoder.encode(memberDTO.getPassword());
			user.setPassword(password);
			user = userService.add(user);
			memberDTO.setMemberId(null);
			Member member = memberService.convertToMember(memberDTO);
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
