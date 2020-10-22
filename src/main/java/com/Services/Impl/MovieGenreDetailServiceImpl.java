package com.Services.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Entity.MovieGenreDetail;
import com.Repository.MovieGenreDetailRepository;
import com.Services.MovieGenreDetailService;

@Service
public class MovieGenreDetailServiceImpl implements MovieGenreDetailService {
	@Autowired
	MovieGenreDetailRepository repository;
	

	@Override
	public MovieGenreDetail add(MovieGenreDetail movieGenreDetail) {
		return repository.save(movieGenreDetail);
	}

	@Override
	public MovieGenreDetail save(MovieGenreDetail movieGenreDetail) {
		return repository.saveAndFlush(movieGenreDetail);
	}

}
