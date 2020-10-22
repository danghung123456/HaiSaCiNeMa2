package com.DTO;

import java.sql.Date;

import com.Entity.Cinema;
import com.Entity.Employee;
import com.Entity.Movie;
import com.Entity.Period;
import com.Entity.Room;
import com.Entity.Showtimes;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShowtimesDTO {
	private Integer showtimeId;
	private Movie movie;
	private Room room;
	private Date date;
	private Period period;
	private Employee employee;
	private Cinema cinema;
	private Integer status;

	public boolean isNull(boolean includeId) {
		boolean res = isNull(movie.getMovieId()) || isNull(room.getRoomId()) || isNull(period.getPeriodId())
				|| isNull(employee.getEmployeeid()) || isNull(cinema.getCinemaId()) || isNull(status);
		return includeId ? res || isNull(showtimeId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public Showtimes convertToShowtimes() {
		ObjectMapper mapper = new ObjectMapper();
		Showtimes showtime = mapper.convertValue(this, Showtimes.class);
		if (isNull(status)) {
			showtime.setStatus(1);
		}
		return showtime;
	}

	public ShowtimesDTO() {

	}

	public ShowtimesDTO(Integer showtimeId, Movie movie, Room room, Date date, Period period, Employee employee,
			Cinema cinema, Integer status) {
		super();
		this.showtimeId = showtimeId;
		this.movie = movie;
		this.room = room;
		this.date = date;
		this.period = period;
		this.employee = employee;
		this.cinema = cinema;
		this.status = status;
	}

	public Integer getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ShowtimesDTO [showtimeId=" + showtimeId + ", movie=" + movie + ", room=" + room + ", date=" + date
				+ ", period=" + period + ", employee=" + employee + ", cinema=" + cinema + ", status=" + status + "]";
	}

}
