package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Member;
import com.Repository.MemberRepository;
import com.Services.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository repository;

	public List<Member> findAll() {
		return repository.findAll();
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public Member add(Member member) {
		return repository.save(member);
	}

	public List<Member> addAll(List<Member> list) {
		List<Member> res = new ArrayList<>();
		for (Member member : list) {
			res.add(add(member));
		}
		return res;
	}

	public Optional<Member> findById(Integer id) {
		return repository.findById(id);
	}

	public List<Member> findByName(String name) {
		return repository.findByMemberName(name);
	}

	public Member save(Member member){
        return repository.saveAndFlush(member);
    }

	}

