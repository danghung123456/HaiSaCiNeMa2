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

	List<Showtimes> getAll();

	void deleteAll();

	Showtimes add(Showtimes showtimes);

	List<Showtimes> addAll(List<Showtimes> list);
	
	List<Showtimes> findByMovieName(String movieName);

	Optional<Showtimes> findById(Integer id);

	Showtimes save(Showtimes showtimes);

	List<Showtimes> findShowtimesByStatus(Integer status);
	
	Showtimes convert(ShowtimesDTO dto);

}
