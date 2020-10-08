package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Cinema;
import com.Entity.Showtimes;
import com.Repository.ShomtimesRepository;
import com.Services.ShowtimesService;

@Service
public class ShowtimesServiceImpl implements ShowtimesService {
	@Autowired
    ShomtimesRepository repository;
	
	@Override
	public Page<Showtimes> getAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public void deleteAll() {
		 repository.deleteAll();
		
	}

	@Override
	public Showtimes add(Showtimes showtimes) {
		
		return repository.save(showtimes);
	}

	@Override
	public List<Showtimes> addAll(List<Showtimes> list) {
		 List<Showtimes> res = new ArrayList<>();
	        for (Showtimes showtimes : list){
	            res.add(add(showtimes));
	        }
	        return res;
	}

	@Override
	public Optional<Showtimes> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Showtimes save(Showtimes showtimes) {
		return repository.saveAndFlush(showtimes);
	}

}
