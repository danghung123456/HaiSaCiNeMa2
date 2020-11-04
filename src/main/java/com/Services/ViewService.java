package com.Services;

import java.util.List;

import com.DTO.view.GenreMovieView;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
import com.Entity.GenreMovie;

public interface ViewService {
	
	List<TicketByShowtimeView> getTicketByShowtime();
	
	List<TicketByMovieView> getTicketByMovie();
	
	List<TotalByCinemaView> getTotalByCinema();
	
	List<GenreMovieView> getGenreByMovieId(Integer id);
	
}
