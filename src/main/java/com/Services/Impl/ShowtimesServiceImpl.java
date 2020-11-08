package com.Services.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DTO.DatePeriodDTO;
import com.DTO.ShowtimesDTO;
import com.DTO.ShowtimesMovieDTO;
import com.Entity.Cinema;
import com.Entity.Employee;
import com.Entity.Movie;
import com.Entity.Period;
import com.Entity.Room;
import com.Entity.Showtimes;
import com.Repository.CinemaRepository;
import com.Repository.EmployeeRepository;
import com.Repository.MovieRepository;
import com.Repository.PeriodRepository;
import com.Repository.RoomRepository;
import com.Repository.ShowtimesRepository;
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
	MovieRepository movieRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	PeriodRepository periodRepository;
	@Autowired
	CinemaRepository cinemaRepository;

	@Override
	public List<Showtimes> getAll() {
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
		Movie movie = movieRepository.findById(dto.getMovieId()).orElse(null);
		Employee employee = employeeRepository.findById(dto.getEmployeeId()).orElse(null);
		Room room = roomRepository.findById(dto.getRoomId()).orElse(null);
		Period period = periodRepository.findById(dto.getPeriodId()).orElse(null);
		Showtimes showtime = new Showtimes();
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

	@Override
	public List<ShowtimesMovieDTO> listShowtime(Integer movieId) {
		List<ShowtimesMovieDTO> list = new ArrayList<ShowtimesMovieDTO>();
		List<Integer> listCinemaId = repository.findCinemaByMovieId(movieId);
		List<Cinema> listCinema = new ArrayList<>();
		for (Integer cinemaId : listCinemaId) {
			Cinema cinema = cinemaRepository.findById(cinemaId).orElse(null);
			listCinema.add(cinema);
		}
		for (Cinema cinema : listCinema) {
			ShowtimesMovieDTO dto = new ShowtimesMovieDTO();
			dto.setCinemaId(cinema.getCinemaId());
			dto.setCinemaName(cinema.getName());
			dto.setAddress(cinema.getAddress());
			List<Date> listDate = repository.findDateByCinemaMovie(cinema.getCinemaId(), movieId);
			List<DatePeriodDTO> listPeriodDTO = new ArrayList<>();
			for (Date dateIndex : listDate) {
				DatePeriodDTO periodDTO = new DatePeriodDTO();
				periodDTO.setDate(dateIndex);
				List<Showtimes> listShowtimes = repository.findPeriod(cinema.getCinemaId(), movieId, dateIndex);
				List<Period> listPeriod = new ArrayList<>();
				for (Showtimes showtime : listShowtimes) {
					listPeriod.add(showtime.getPeriod());
				}
				periodDTO.setPeriods(listPeriod);
				listPeriodDTO.add(periodDTO);
			}
			dto.setPeriods(listPeriodDTO);
			list.add(dto);
		}
		return list;
	}
}
