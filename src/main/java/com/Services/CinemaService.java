package com.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.Entity.Cinema;

@Service
public interface CinemaService {

	/**
	 * @return list all Movie
	*/
	List<Cinema> getAll();

	void deleteAll();

	/**
	 * This is function add new Cinema
	 * @param
	 * @return entity Cinema
	*/
	Cinema add(Cinema cinema);

	
	List<Cinema> addAll(List<Cinema> list);

	/**
	 * This is function find Cinema by CinemaId
	 * @return Optional Cinema
	*/
	Optional<Cinema> findById(Integer id);

	List<Cinema> findByName(String name);

	Cinema save(Cinema cinema);
}
