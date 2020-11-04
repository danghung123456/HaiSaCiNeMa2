package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.GenreMovie;
@Service
public interface GenreMovieService {
	
	List<GenreMovie> getAll();
	
	GenreMovie save(GenreMovie genre);

	Optional<GenreMovie> findById(Integer id);

	List<GenreMovie> findByName(String name);

	GenreMovie add(GenreMovie genre);
	
	

}
