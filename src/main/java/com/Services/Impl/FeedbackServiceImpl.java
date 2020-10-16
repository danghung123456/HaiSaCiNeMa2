package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Feedback;

import com.Repository.FeedbackRepository;
import com.Services.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackRepository repository;

	@Override
	public Page<Feedback> getAll(Pageable pageable) {
		
		return repository.findAll(pageable);
	}

	@Override
	public Feedback add(Feedback feedback) {
		// TODO Auto-generated method stub
		return repository.save(feedback);
	}

	@Override
	public Feedback save(Feedback feedback) {
		// TODO Auto-generated method stub
		return repository.saveAndFlush(feedback);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}

	@Override
	public List<Feedback> addAll(List<Feedback> list) {
		 List<Feedback> res = new ArrayList<>();
	        for (Feedback feedback : list){
	            res.add(add(feedback));
	        }
	        return res;
		
	}
	


}
