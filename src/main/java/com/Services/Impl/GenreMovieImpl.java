package com.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.GenreMovie;
import com.Repository.GenreMovieRepository;
import com.Services.GenreMovieService;
@Service
public class GenreMovieImpl implements GenreMovieService {
	@Autowired
	GenreMovieRepository repository;
	@Override
	public List<GenreMovie> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public GenreMovie save(GenreMovie genre) {
		// TODO Auto-generated method stub
		return repository.save(genre);
	}

	@Override
	public Optional<GenreMovie> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<GenreMovie> findByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}

	@Override
	public GenreMovie add(GenreMovie genre) {
		// TODO Auto-generated method stub
		return repository.save(genre);
	}

	@Override
	public Page<GenreMovie> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}

}
