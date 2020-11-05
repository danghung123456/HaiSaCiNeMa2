package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DTO.HistoryTransViewDTO;
import com.DTO.view.GenreMovieView;
import com.DTO.view.HistoryTransView;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
import com.Entity.Cinema;
import com.Entity.GenreMovie;
import com.Repository.CinemaRepository;
import com.Repository.ViewRepository;
import com.Services.CinemaService;
import com.Services.ViewService;

@Service
public class ViewServiceImpl implements ViewService {
	@Autowired
	ViewRepository repository;

	@Override
	public List<TicketByShowtimeView> getTicketByShowtime() {
		return repository.getTicketByShowtime();
	}

	@Override
	public List<TicketByMovieView> getTicketByMovie() {
		return repository.getTicketByMovie();
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
		return dto;
	}

}
