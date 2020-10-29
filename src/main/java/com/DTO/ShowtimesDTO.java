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
	private Integer movieId;
	private Integer roomId;
	private Date date;
	private Integer periodId;
	private Integer employeeId;
	private Integer cinemaId;
	private Integer status;
	private Movie movie;
	private Room room;
	private Period period;
	private Employee employee;
	private Cinema cinema;

	public ShowtimesDTO() {

	}

	public ShowtimesDTO(Integer showtimeId, Integer movieId, Integer roomId, Date date, Integer periodId,
			Integer employeeId, Integer cinemaId, Integer status) {
		super();
		this.showtimeId = showtimeId;
		this.movieId = movieId;
		this.roomId = roomId;
		this.date = date;
		this.periodId = periodId;
		this.employeeId = employeeId;
		this.cinemaId = cinemaId;
		this.status = status;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(movieId) || isNull(roomId) || isNull(periodId) || isNull(employeeId) || isNull(cinemaId);
		return includeId ? res || isNull(showtimeId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public Showtimes convertToShowtimes() {
		Movie movie = new Movie();
		movie.setMovieId(this.getMovieId());
		this.setMovie(movie);
		Room room = new Room();
		room.setRoomId(this.getRoomId());
		this.setRoom(room);
		Period period = new Period();
		period.setPeriodId(this.getPeriodId());
		this.setPeriod(period);
		Employee employee = new Employee();
		employee.setEmployeeId(this.getEmployeeId());
		this.setEmployee(employee);
		Cinema cinema = new Cinema();
		cinema.setCinemaId(this.getCinemaId());
		this.setCinema(cinema);
		ObjectMapper mapper = new ObjectMapper();
		Showtimes showtime = mapper.convertValue(this, Showtimes.class);
		if (isNull(status)) {
			showtime.setStatus(1);
		}
		return showtime;
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

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Integer periodId) {
		this.periodId = periodId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}

	@Override
	public String toString() {
		return "ShowtimesDTO [showtimeId=" + showtimeId + ", movieId=" + movieId + ", roomId=" + roomId + ", date="
				+ date + ", periodId=" + periodId + ", employeeId=" + employeeId + ", cinemaId=" + cinemaId
				+ ", status=" + status + "]";
	}

}
