package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
import com.Entity.Cinema;
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
}
	

	
