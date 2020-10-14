package com.Services;

import com.Entity.Member;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {

	public List<Member> findAll();
	
    public void deleteAll();

    public Member add(Member member);

    public List<Member> addAll(List<Member> list);
    
    public Optional<Member> findById(Integer id);
    
    public List<Member> findByName(String name);

    public Member save(Member member);
}
