package com.Services.Impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.HistoryTransViewDTO;
import com.DTO.view.GenreMovieView;
import com.DTO.view.HistoryTransView;
import com.DTO.view.TopMovieView;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
import com.Repository.ShowtimesRepository;
import com.Repository.ViewRepository;
import com.Services.ViewService;

@Service
public class ViewServiceImpl implements ViewService {
	@Autowired
	ViewRepository repository;
	@Autowired
	ShowtimesRepository showtimesRepository;

	@Override
	public List<TicketByShowtimeView> getTicketByShowtime() {
		return repository.getTicketByShowtime();
	}

	@Override
	public List<TicketByMovieView> getTicketByMovie(Integer status) {
		return repository.getTicketByMovie(status);
	}
	
	@Override
	public List<TicketByMovieView> getTicketOfMonthByMovie() {
		return repository.getTicketOfMonthByMovie();
		
	}


	@Override
	public List<TotalByCinemaView> getTotalOfMonthByCinema() {
		return repository.getTotalOfMonthByCinema();
	}

	@Override
	public List<TotalByCinemaView> getTotalByCinema() {
		return repository.getTotalByCinema();
	}

	@Override
	public List<GenreMovieView> getGenreByMovieId(Integer id) {
		return repository.getGenreByMovieId(id);

	}

	@Override
	public List<HistoryTransView> getTicketBought(Integer id) {
		return repository.getTicketBought(id);
	}

	@Override
	public HistoryTransViewDTO convertToDtos(HistoryTransView historyTransView) {
		HistoryTransViewDTO dto = new HistoryTransViewDTO();
		dto.setTicketId(historyTransView.getticketId());
		dto.setMemberName(historyTransView.getmemberName());
		dto.setTicketQuantity(historyTransView.getticketQuantity());
		dto.setTotal(historyTransView.gettotal());
		dto.setMovieName(historyTransView.getmovieName());
		dto.setEmployeeName(historyTransView.getemployeeName());
		dto.setDate(historyTransView.getDate());
		dto.setCinemaName(historyTransView.getcinemaName());
		dto.setRoom(historyTransView.getroom());
		dto.setShowtime(historyTransView.getshowtime());
		dto.setTicketPrice(historyTransView.getticketPrice());
		dto.setFoodPrice(historyTransView.getfoodPrice());
		return dto;
	}

	@Override
	public List<TopMovieView> getMovieOfWeek() {
		Date dateNow = new Date();
		long msOfNow = dateNow.getTime();
		Date date = new Date(msOfNow - 604800016);
		return repository.getTopMovie(dateNow, date);
	}

	@Override
	public List<TopMovieView> getMovieOfMonth() {
		Date dateNow = new Date();
		long msOfNow = dateNow.getTime();
		Date date = new Date(msOfNow - 2629800000L);
		return repository.getTopMovie(dateNow, date);
	}



}
