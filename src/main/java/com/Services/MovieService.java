package com.Services;

import com.Entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

	 	public Page<Movie> getAll(Pageable pageable);

	    public Movie add(Movie movie);
	    
	    public Movie save(Movie movie);
	    
	    public void deleteAll();

	    public List<Movie> addAll(List<Movie> list);
	    
	    public Page<Movie> findMovieByStatus(Integer status, Pageable pageable);
	    
	    public Optional<Movie> findById(Integer id);
	    
	    public List<Movie> findByName(String name);
	    
<<<<<<< HEAD
	
=======
	   
>>>>>>> 6afbf360483d921cdd3533b8d03d15c40e343080
}
