package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.DTO.Base.ResponseEntiy;

@RestController
@RequestMapping(value = "member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping
	public List<Member> index() {
		return memberService.findAll();
	}

	@PostMapping(value = "/add")
	public ResponseEntiy<Object> addMember(@RequestBody MemberDTO memberDTO) {
		 if (memberDTO.isNull(false)) {
	            return ResponseEntiy.body(Constant.BAD_REQUEST);
	        } else {
	            //Make sure id is NULL to insert Entity
	            memberDTO.setMemberId(null);
	            Member member = memberDTO.convertToMember();
	            return ResponseEntiy.body(memberService.add(member));
	        }
	} 
	
	@PutMapping(value = "/update")
	public ResponseEntiy<Object> updateMember(@RequestBody MemberDTO memberDTO) {
		if (memberDTO.isNull(true)) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Member> checkMember = memberService.findById(memberDTO.getMemberId());
            if (checkMember.isPresent()) {
                Member member = memberDTO.convertToMember();
                return ResponseEntiy.body(memberService.save(member));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	@GetMapping("/findbyid")
	public ResponseEntiy<Object> findById(Integer id) {
		return  ResponseEntiy.body(memberService.findById(id));
	}
	
	@GetMapping("/findbyname")
	public ResponseEntiy<Object> findByName(String name) {
		return ResponseEntiy.body(memberService.findByName(name));
	}

}
