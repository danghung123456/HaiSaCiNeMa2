package com.Services.Impl;

import com.Entity.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Employee;
import com.Repository.PeriodRepository;
import com.Services.PeriodService;

@Service
public class PeriodServiceImpl implements PeriodService {

	@Autowired
	PeriodRepository repository;

	@Override
	public List<Period> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		repository.deleteAll();
	}

	@Override
	public Period add(Period period) {
		// TODO Auto-generated method stub
		return repository.save(period);
	}

	@Override
	public List<Period> addAll(List<Period> list) {
		List<Period> res = new ArrayList<>();
		for (Period period : list) {
			res.add(add(period));
		}
		return res;
	}

	@Override
	public Optional<Period> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Period> findByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}

	@Override
	public Period save(Period period) {
		// TODO Auto-generated method stub
		return repository.saveAndFlush(period);
	}

	@Override
	public List<Period> findPeriodByStatus(Integer status) {
		// TODO Auto-generated method stub
		return repository.findPeriodByStatus(status);
	}
	
	

}
