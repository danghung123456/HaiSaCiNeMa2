package com.Services;

import java.util.List;

import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;

public interface ViewService {
	
	List<TicketByShowtimeView> getTicketByShowtime();
	
	List<TicketByMovieView> getTicketByMovie();
	
	List<TotalByCinemaView> getTotalByCinema();
	
}
