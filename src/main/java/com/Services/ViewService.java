package com.Services;

import java.util.List;

import com.DTO.HistoryTransViewDTO;
import com.DTO.TotalMemberFeedbackMovieTicket;
import com.DTO.view.GenreMovieView;
import com.DTO.view.HistoryTransView;
import com.DTO.view.TopMovieView;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;

public interface ViewService {

	List<TicketByShowtimeView> getTicketByShowtime(Integer cinemaId);

	List<TicketByMovieView> getTicketByMovie(Integer status);

	List<TicketByMovieView> getTicketOfMonthByMovie(Integer month);

	List<TotalByCinemaView> getTotalOfMonthByCinema(Integer cinemaId);

	List<TotalByCinemaView> getTotalByCinema();

	List<GenreMovieView> getGenreByMovieId(Integer id);

	List<HistoryTransView> getTicketBought(Integer id);

	HistoryTransViewDTO convertToDtos(HistoryTransView historyTransView);

	List<TopMovieView> getMovieOfWeek();

	List<TopMovieView> getMovieOfMonth();
	
	TotalMemberFeedbackMovieTicket getTotalMemberFeedbackMovieTicket();

}
