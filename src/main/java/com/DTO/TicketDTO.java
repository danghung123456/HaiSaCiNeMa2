package com.DTO;

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
	private Integer ticketPriceAmount;
	private Integer code;
	private Integer total;
	private Member member;
	private Showtimes showtimes;

	public TicketDTO() {
		super();
	}

	public TicketDTO(Integer ticketId, Integer ticketQuantity, Integer memberId, Integer showtimeId,
			Integer ticketPriceAmount, Integer code, Integer total) {
		super();
		this.ticketId = ticketId;
		this.ticketQuantity = ticketQuantity;
		this.memberId = memberId;
		this.showtimeId = showtimeId;
		this.ticketPriceAmount = ticketPriceAmount;
		this.code = code;
		this.total = total;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(ticketQuantity) || isNull(memberId) || isNull(code) || isNull(ticketPriceAmount)
				|| isNull(showtimeId);
		return includeId ? res || isNull(ticketId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public TicketDetail convertToCinema() {
		Showtimes showtimes = new Showtimes();
		showtimes.setShowtimeId(this.getShowtimeId());
		this.setShowtimes(showtimes);
		Member member = new Member();
		member.setMemberId(this.getMemberId());
		this.setMember(member);
		ObjectMapper mapper = new ObjectMapper();
		TicketDetail ticketDetail = mapper.convertValue(this, TicketDetail.class);
		return ticketDetail;
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

	public Integer getTicketPriceAmount() {
		return ticketPriceAmount;
	}

	public void setTicketPriceAmount(Integer ticketPriceAmount) {
		this.ticketPriceAmount = ticketPriceAmount;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Showtimes getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(Showtimes showtimes) {
		this.showtimes = showtimes;
	}

	@Override
	public String toString() {
		return "TicketDTO [ticketId=" + ticketId + ", ticketQuantity=" + ticketQuantity + ", memberId=" + memberId
				+ ", showtimeId=" + showtimeId + ", ticketPriceAmount=" + ticketPriceAmount + ", code=" + code
				+ ", total=" + total + "]";
	}

}
