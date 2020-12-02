package com.Services;

import com.DTO.MemberDTO;
import com.Entity.Member;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {

	List<Member> getAll();

	void deleteAll();

	Member add(Member member);

	List<Member> addAll(List<Member> list);

	Optional<Member> findById(Integer id);

	List<Member> findByName(String name);

	Member save(Member member);
	
	Member convertToMember(MemberDTO memberDTO);
	
	Member getMemberByEmail(String email);
}
