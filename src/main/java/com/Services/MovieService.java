package com.Services;

import com.DTO.MovieDTO;
import com.Entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

	 	 List<Movie> getAll();

	     Movie add(Movie movie);
	    
	     Movie save(Movie movie);
	    
	     void deleteAll();

	     List<Movie> addAll(List<Movie> list);
	    
	     List<Movie> findMovieByStatus(Integer status);
	    
	     Optional<Movie> findById(Integer id);
	    
	     List<Movie> findByName(String name);
	     
	     

}
