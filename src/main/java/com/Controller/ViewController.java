package com.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;

import com.Services.ViewService;

@RestController
@RequestMapping(value = "view")

public class ViewController {

	@Autowired
	private ViewService viewService;

	@GetMapping("/ticketbymovie")
	public List<TicketByMovieView> getTicketByMovie() {
		return viewService.getTicketByMovie();
	}

	@GetMapping("/ticketbyshowtime")
	public List<TicketByShowtimeView> getTicketByShowtime() {
		return viewService.getTicketByShowtime();
	}

	@GetMapping("/totalbycinema")
	public List<TotalByCinemaView> getTotalByCinema() {
		return viewService.getTotalByCinema();
	}
}
