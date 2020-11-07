package com.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.HistoryTransViewDTO;
import com.DTO.view.GenreMovieView;
import com.DTO.view.HistoryTransView;
import com.DTO.view.StartTimeView;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
import com.Entity.TicketDetail;
import com.Services.FoodBillDetailService;
import com.Services.PeriodService;
import com.Services.TicketDetailService;
import com.Services.TicketService;
import com.Services.ViewService;

@RestController
@RequestMapping(value = "view")

public class ViewController {

	@Autowired
	private ViewService viewService;
	@Autowired
	private FoodBillDetailService foodBillDetailService;
	@Autowired
	private TicketService ticketService;

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

	@GetMapping("/findgenre")
	public List<GenreMovieView> getGenreByMovieId(Integer id){
		return viewService.getGenreByMovieId(id);
		
	}
	@GetMapping("/historytrans")
	public List<HistoryTransViewDTO> getHistoryTransaction(Integer id){
		List<HistoryTransView> list = viewService.getTicketBought(id);
		List<HistoryTransViewDTO> listDTO = new ArrayList<>();
		for (HistoryTransView historyTransView : list) {
			HistoryTransViewDTO dto = new HistoryTransViewDTO();
			dto = viewService.convertToDtos(historyTransView);
			List<String> listSeat = new ArrayList<>();
			List<TicketDetail> listTicketDetail = ticketService.findById(historyTransView.getticketId()).get().getTicketDetail();
			for (TicketDetail ticketDetail : listTicketDetail) {
				listSeat.add(ticketDetail.getSeat().getSeatName());
			}
			dto.setSeats(listSeat);
			dto.setFoodPrice(foodBillDetailService.getTotalFood(historyTransView.getticketId()));
			listDTO.add(dto);
		}
		return listDTO;
	}
	}