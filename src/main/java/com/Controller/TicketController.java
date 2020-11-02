package com.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.FoodBillDetailDTO;
import com.DTO.MovieDTO;
import com.DTO.SeatDTO;
import com.DTO.SeatStatusDTO;
import com.DTO.TicketDTO;
import com.Entity.Food;
import com.Entity.FoodBillDetail;
import com.Entity.Member;
import com.Entity.Movie;
import com.Entity.Seat;
import com.Entity.SeatStatus;
import com.Entity.Ticket;
import com.Entity.TicketDetail;
import com.Services.FoodBillDetailService;
import com.Services.FoodService;
import com.Services.MemberService;
import com.Services.MovieService;
import com.Services.SeatService;
import com.Services.SeatStatusService;
import com.Services.TicketDetailService;
import com.Services.TicketService;
import com.Constant.*;
import com.DTO.Base.ResponseEntiy;
import com.DTO.view.TicketByCinemaView;
import com.DTO.view.TicketByShowtimeView;

@RestController
@RequestMapping(value = "ticket")

public class TicketController {

	@Autowired
	private TicketService ticketService;
	@Autowired
	private SeatService seatService;
	@Autowired
	private TicketDetailService ticketDetailService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private FoodBillDetailService foodBillDetailService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private SeatStatusService seatStatusService;


	@GetMapping(value = "/index")
	public  List<Ticket> index() {
		return  ticketService.getAll();
	}

	@PostMapping(value = "/book")
	public ResponseEntiy<Object> bookTicket(@RequestBody TicketDTO ticketDTO) {
		 if (ticketDTO.isNull(false)) {
	            return ResponseEntiy.body(Constant.BAD_REQUEST);
	        } else {
	            //Make sure id is NULL to insert Entity
	        	ticketDTO.setTicketId(null);
	            Ticket ticket = ticketService.converToTicket(ticketDTO);
	            ticket = ticketService.save(ticket);
	            List<SeatDTO> listSeat = ticketDTO.getListSeat();
	            List<FoodBillDetailDTO> listFoodBillDetailDTO = ticketDTO.getListFoodBillDetail();
	            List<SeatStatusDTO> listSeatStatusDTO = ticketDTO.getListSeatStatus();
	            for (SeatDTO seatDTO : listSeat) {
	            	Seat seat = seatService.findById(seatDTO.getSeatId()).orElse(null);
					TicketDetail ticketDetail = new TicketDetail();
					ticketDetail.setTicket(ticket);
					ticketDetail.setSeat(seat);
					ticketDetailService.save(ticketDetail);
				}
	            for (FoodBillDetailDTO foodsDto : listFoodBillDetailDTO) {
	            	Food food = foodService.findById(foodsDto.getFoodId()).orElse(null);
	            	FoodBillDetail foodBillDetail = new FoodBillDetail();
	            	foodBillDetail.setTicket(ticket);
	            	foodBillDetail.setFood(food);
	            	foodBillDetail.setQuantity(foodsDto.getQuantity());
	            	foodBillDetail.setTotal(foodsDto.getTotal());
	            	foodBillDetailService.save(foodBillDetail);
				}
	            for (SeatStatusDTO seatStatusDTO : listSeatStatusDTO) {
	            	SeatStatus seatStatus = seatStatusService.findById(seatStatusDTO.getSeatStatusId()).orElse(null);
	            	seatStatus.setStatus(true);
	            	seatStatusService.save(seatStatus);
				}
	            Member member = new Member();
	            member = memberService.findById(ticket.getMember().getMemberId()).orElse(null);
	            Double total = ticket.getTotal() + member.getTotalMoney();
	            member.setTotalMoney(total);
	            ticket = ticketService.findById(ticket.getTicketId()).orElse(null);
	            return ResponseEntiy.body(ticket);
	        }
	} 
	
	
	
	@GetMapping("/findbyid")
	public ResponseEntiy<Object> findById(Integer id) {
		return  ResponseEntiy.body(ticketService.findById(id));
	}
	
	@GetMapping("/ticketbycinema")
	public List<TicketByCinemaView> getTicketByCinema(){
		return ticketService.getTicketByCinema();
	}
	
	@GetMapping("/ticketbyshowtime")
	public List<TicketByShowtimeView> getTicketByShowtime(){
		return ticketService.getTicketByShowtime();
	}

}
