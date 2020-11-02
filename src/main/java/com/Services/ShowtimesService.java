package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.DTO.ShowtimesDTO;
import com.Entity.Showtimes;

@Service
public interface ShowtimesService {

	Page<Showtimes> getAll(Pageable pageable);

	void deleteAll();

	Showtimes add(Showtimes showtimes);

	List<Showtimes> addAll(List<Showtimes> list);

	Optional<Showtimes> findById(Integer id);

	Showtimes save(Showtimes showtimes);

	Page<Showtimes> findShowtimesByStatus(Integer status, Pageable pageable);
	
	Showtimes convert(ShowtimesDTO dto);

}
