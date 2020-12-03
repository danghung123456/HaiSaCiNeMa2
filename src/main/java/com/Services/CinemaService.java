package com.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.Entity.Cinema;

@Service
public interface CinemaService {

	List<Cinema> getAll();

	void deleteAll();

	Cinema add(Cinema cinema);

	List<Cinema> addAll(List<Cinema> list);

	Optional<Cinema> findById(Integer id);

	List<Cinema> findByName(String name);

	Cinema save(Cinema cinema);

}
