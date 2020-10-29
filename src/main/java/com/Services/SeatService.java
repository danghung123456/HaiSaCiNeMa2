package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Seat;

@Service
public interface SeatService {
	
	Page<Seat> findAll(Pageable pageable);

	List<Seat> findAll();

	Seat save(Seat seat);

	List<Seat> findByName(String name);

	Optional<Seat> findById(Integer id);
}
