package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Cinema;
import com.Repository.CinemaRepository;
import com.Services.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {
	@Autowired
    CinemaRepository repository;
	

	@Override
	public Page<Cinema> getAll(Pageable pageable) {
		
		return repository.findAll(pageable);
	}

	@Override
	public void deleteAll() {
		 repository.deleteAll();
		
	}

	@Override
	public Cinema add(Cinema cinema) {
		return repository.save(cinema);
	}

	@Override
	public List<Cinema> addAll(List<Cinema> list) {
		 List<Cinema> res = new ArrayList<>();
	        for (Cinema cinema : list){
	            res.add(add(cinema));
	        }
	        return res;
	}

	@Override
	public Optional<Cinema> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Cinema> findByName(String name) {
		
		return repository.findByName(name);
	}

	@Override
	public Cinema save(Cinema cinema) {
		return repository.saveAndFlush(cinema);
	}

}
