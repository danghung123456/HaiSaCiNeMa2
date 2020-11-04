package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DTO.MemberDTO;
import com.Entity.Member;
import com.Services.MemberService;
import com.Constant.*;
import com.DTO.Base.ResponseEntity;

@RestController
@RequestMapping(value = "member")

public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping
	
	public ResponseEntity<List<Member>> index() {
		return ResponseEntity.body(memberService.getAll());
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addMember(@RequestBody MemberDTO memberDTO) {
		 if (memberDTO.isNull(false)) {
	            return ResponseEntity.body(Constant.BAD_REQUEST);
	        } else {
	            //Make sure id is NULL to insert Entity
	            memberDTO.setMemberId(null);
	            Member member = memberDTO.convertToMember();
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
                Member member = memberDTO.convertToMember();
                return ResponseEntity.body(memberService.save(member));
            } else {
                return ResponseEntity.body(Constant.NOT_FOUND);
            }
        }
	}
	@GetMapping("/findbyid")
	public ResponseEntity<Object> findById(Integer id) {
		return  ResponseEntity.body(memberService.findById(id));
	}
	
	@GetMapping("/findbyname")
	public ResponseEntity<Object> findByName(String name) {
		return ResponseEntity.body(memberService.findByName(name));
	}

}
