package com.DTO;

import com.Entity.Cinema;
import com.Entity.Movie;
import com.Entity.Seat;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SeatStatusDTO {
	private Integer seatStatusId;
	private Showtimes showtimes;
	private Seat seat;
	private int status;

	public boolean isNull(boolean includeId) {
		boolean res = isNull(showtimes.getShowtimeId()) || isNull(seat.getSeatId());
		return includeId ? res || isNull(seatStatusId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public SeatStatus convertToCinema() {
		ObjectMapper mapper = new ObjectMapper();
		SeatStatus seatStatus = mapper.convertValue(this, SeatStatus.class);
		return seatStatus;
	}

	public SeatStatusDTO() {

	}

	public SeatStatusDTO(Integer seatStatusId, Showtimes showtimes, Seat seat, int status) {
		super();
		this.seatStatusId = seatStatusId;
		this.showtimes = showtimes;
		this.seat = seat;
		this.status = status;
	}

	public Integer getSeatStatusId() {
		return seatStatusId;
	}

	public void setSeatStatusId(Integer seatStatusId) {
		this.seatStatusId = seatStatusId;
	}

	public Showtimes getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(Showtimes showtimes) {
		this.showtimes = showtimes;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SeatStatusDTO [seatStatusId=" + seatStatusId + ", showtimes=" + showtimes + ", seat=" + seat
				+ ", status=" + status + "]";
	}

}
