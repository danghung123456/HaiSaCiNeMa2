package com.DTO;

import java.util.List;

import com.Entity.Cinema;
import com.Entity.Member;
import com.Entity.Movie;
import com.Entity.Seat;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;
import com.Entity.Ticket;
import com.Entity.TicketDetail;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TicketDTO {
	private Integer ticketId;
	private Integer ticketQuantity;
	private Integer memberId;
	private Integer showtimeId;
	private Double ticketPriceAmount;
	private String code;
	private Double total;
	private List<SeatStatusDTO> listSeatStatus;
	private List<SeatDTO> listSeat;
	private List<FoodBillDetailDTO> listFoodBillDetail;

	public TicketDTO() {
		super();
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(ticketQuantity) || isNull(memberId) || isNull(showtimeId);
		return includeId ? res || isNull(ticketId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getTicketQuantity() {
		return ticketQuantity;
	}

	public void setTicketQuantity(Integer ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}

	public Double getTicketPriceAmount() {
		return ticketPriceAmount;
	}

	public void setTicketPriceAmount(Double ticketPriceAmount) {
		this.ticketPriceAmount = ticketPriceAmount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<SeatDTO> getListSeat() {
		return listSeat;
	}

	public void setListSeat(List<SeatDTO> listSeat) {
		this.listSeat = listSeat;
	}

	public List<FoodBillDetailDTO> getListFoodBillDetail() {
		return listFoodBillDetail;
	}

	public void setListFoodBillDetail(List<FoodBillDetailDTO> listFoodBillDetail) {
		this.listFoodBillDetail = listFoodBillDetail;
	}

	public List<SeatStatusDTO> getListSeatStatus() {
		return listSeatStatus;
	}

	public void setListSeatStatus(List<SeatStatusDTO> listSeatStatus) {
		this.listSeatStatus = listSeatStatus;
	}

	@Override
	public String toString() {
		return "TicketDTO [ticketId=" + ticketId + ", ticketQuantity=" + ticketQuantity + ", memberId=" + memberId
				+ ", showtimeId=" + showtimeId + ", ticketPriceAmount=" + ticketPriceAmount + ", code=" + code
				+ ", total=" + total + ", listSeat=" + listSeat + ", listFoodBillDetail=" + listFoodBillDetail + "]";
	}

}
