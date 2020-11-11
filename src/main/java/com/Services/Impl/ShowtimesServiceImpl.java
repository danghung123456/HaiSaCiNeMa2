	package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DTO.ShowtimesDTO;
import com.Entity.Cinema;
import com.Entity.Employee;
import com.Entity.Movie;
import com.Entity.Period;
import com.Entity.Room;
import com.Entity.Showtimes;
import com.Repository.ShowtimesRepository;
import com.Services.CinemaService;
import com.Services.EmployeeService;
import com.Services.MovieService;
import com.Services.PeriodService;
import com.Services.RoomService;
import com.Services.ShowtimesService;

@Service
public class ShowtimesServiceImpl implements ShowtimesService {
	
	@Autowired
	ShowtimesRepository repository;
	@Autowired
	MovieService movieService;
	@Autowired
	EmployeeService empService;
	@Autowired
	RoomService roomService;
	@Autowired
	PeriodService periodService;

	@Override
	public List<Showtimes> getAllShowtimes() {
		return repository.findAll();
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();

	}

	@Override
	public Showtimes add(Showtimes showtimes) {
		return repository.save(showtimes);
	}

	@Override
	public List<Showtimes> addAll(List<Showtimes> list) {
		List<Showtimes> res = new ArrayList<>();
		for (Showtimes showtimes : list) {
			res.add(add(showtimes));
		}
		return res;
	}

	@Override
	public Optional<Showtimes> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Showtimes save(Showtimes showtimes) {
		return repository.saveAndFlush(showtimes);
	}

	@Override
	public List<Showtimes> findShowtimesByStatus(Integer status) {
		return repository.findShowtimesByStatus(status);
	}


	@Override
	public Showtimes convert(ShowtimesDTO dto) {
		Showtimes showtime = new Showtimes();
		Movie movie = movieService.findById(dto.getMovieId()).orElse(null);
		Employee employee = empService.findById(dto.getEmployeeId()).orElse(null);
		Room room = roomService.findById(dto.getRoomId()).orElse(null);
		Period period = periodService.findById(dto.getPeriodId()).orElse(null);
		showtime.setShowtimeId(dto.getShowtimeId());
		showtime.setMovie(movie);
		showtime.setEmployee(employee);
		showtime.setRoom(room);
		showtime.setPeriod(period);
		showtime.setDate(dto.getDate());
		showtime.setStatus(1);
		return showtime;
	}

	@Override
	public List<Showtimes> findByMovieName(String movieName) {
		return repository.findByName(movieName);
	}

//	@Override
//	public List<showMovieDTO> findAll() {
//		// TODO Auto-generated method stub
//		return repoView.myView();
//	}

}
