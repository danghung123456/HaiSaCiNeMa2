package com.Services.Impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.HistoryTransViewDTO;
import com.DTO.TotalMemberFeedbackMovieTicket;
import com.DTO.view.GenreMovieView;
import com.DTO.view.HistoryTransView;
import com.DTO.view.TopMovieView;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
import com.Repository.FeedbackRepository;
import com.Repository.MemberRepository;
import com.Repository.MovieRepository;
import com.Repository.ShowtimesRepository;
import com.Repository.TicketRepository;
import com.Repository.ViewRepository;
import com.Services.ViewService;

@Service
public class ViewServiceImpl implements ViewService {
	@Autowired
	ViewRepository repository;
	@Autowired
	ShowtimesRepository showtimesRepository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired 
	FeedbackRepository feedbackRepository;
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<TicketByShowtimeView> getTicketByShowtime(Integer cinemaId) {
		return repository.getTicketByShowtime(cinemaId);
	}

	@Override
	public List<TicketByMovieView> getTicketOfMonthByMovie(Integer month) {
		Date date = new Date();
		Integer year = date.getYear() + 1900;
		return repository.getTicketOfMonthByMovie(month, year);
	}
		
	public List<TicketByMovieView> getTicketByMovie(Integer status) {
		return repository.getTicketByMovie(status);
	}
	

	@Override
	public List<TotalByCinemaView> getTotalOfMonthByCinema(Integer cinemaId) {
		return repository.getTotalOfMonthByCinema(cinemaId);
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
		Date date = new Date(msOfNow - 604800000);
		return repository.getTopMovie(dateNow, date);
	}

	@Override
	public List<TopMovieView> getMovieOfMonth() {
		Date dateNow = new Date();
		long msOfNow = dateNow.getTime();
		Date date = new Date(msOfNow - 2629800000L);
		return repository.getTopMovie(dateNow, date);
	}

	@Override
	public TotalMemberFeedbackMovieTicket getTotalMemberFeedbackMovieTicket() {
		TotalMemberFeedbackMovieTicket total = new TotalMemberFeedbackMovieTicket();
		total.setMember(memberRepository.totalMember());
		total.setFeedback(feedbackRepository.totalFeedback());
		total.setMovie(movieRepository.totalMovie());
		total.setTicket(ticketRepository.totalTicket());
		return total;
	}



}
