package com.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.Entity.Cinema;



@Service
public interface CinemaService {
	
	 	public List<Cinema> getAll();

	    public void deleteAll();

	    public Cinema add(Cinema cinema);

	    public List<Cinema> addAll(List<Cinema> list);
	    
	    public Optional<Cinema> findById(Integer id);
	    
	    public List<Cinema> findByName(String name);

	    public Cinema save(Cinema cinema);
}
