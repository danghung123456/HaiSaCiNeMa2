package com.DTO;

import com.Entity.Cinema;
import com.Entity.Movie;
import com.Entity.Seat;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;
import com.Entity.Ticket;
import com.Entity.TicketDetail;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TicketDetailDTO {
	private Integer ticketDetatailId;
	private Ticket ticket;
	private Seat seat;

	public boolean isNull(boolean includeId) {
		boolean res = isNull(ticket.getTicketId()) || isNull(seat.getSeatId());
		return includeId ? res || isNull(ticketDetatailId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public TicketDetail convertToCinema() {
		ObjectMapper mapper = new ObjectMapper();
		TicketDetail ticketDetail = mapper.convertValue(this, TicketDetail.class);
		return ticketDetail;
	}

	public TicketDetailDTO() {

	}

	public TicketDetailDTO(Integer ticketDetatailId, Ticket ticket, Seat seat) {
		super();
		this.ticketDetatailId = ticketDetatailId;
		this.ticket = ticket;
		this.seat = seat;
	}

	public Integer getTicketDetatailId() {
		return ticketDetatailId;
	}

	public void setTicketDetatailId(Integer ticketDetatailId) {
		this.ticketDetatailId = ticketDetatailId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "TicketDetailDTO [ticketDetatailId=" + ticketDetatailId + ", ticket=" + ticket + ", seat=" + seat + "]";
	}

}
