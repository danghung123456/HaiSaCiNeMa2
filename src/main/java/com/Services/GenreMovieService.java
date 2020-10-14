package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.GenreMovie;
@Service
public interface GenreMovieService {
	Page<GenreMovie> getAll(Pageable pageable);
	
	List<GenreMovie> findAll();

	GenreMovie save(GenreMovie genre);

	Optional<GenreMovie> findById(Integer id);

	List<GenreMovie> findByName(String name);

	GenreMovie add(GenreMovie genre);
//	still don't know how to handle this issue yet
//	List<GenreMovie> findMovieByGenre();
}
