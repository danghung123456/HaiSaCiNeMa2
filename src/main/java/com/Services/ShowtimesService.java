package com.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DTO.ShowtimePeriodDTO;
import com.DTO.ShowtimesDTO;
import com.DTO.ShowtimesMovieDTO;
import com.Entity.Period;
import com.Entity.Showtimes;

@Service
public interface ShowtimesService {

	List<Showtimes> getAllShowtimes();

	void deleteAll();

	Showtimes add(Showtimes showtimes);

	List<Showtimes> addAll(List<Showtimes> list);

	Optional<Showtimes> findById(Integer id);

	Showtimes save(Showtimes showtimes);

	List<Showtimes> findShowtimesByStatus(Integer status);

	Showtimes convert(ShowtimesDTO dto);

	List<ShowtimesMovieDTO> listShowtime(Integer movieId);
	
	void updateShowtimeByPreviousDate();
	
	List<Showtimes> getShowtimesByCinema(Integer id);
	
	

}
