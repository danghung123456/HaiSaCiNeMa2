package com.DTO;

import java.sql.Date;


import com.Entity.Showtimes;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShowtimesDTO {
	 private Integer showtimeId;
	 private String movieId;
	 private Integer roomId;
	 private Date date;
	 private Integer period;
	 private Integer employeeId;
	 private Integer cinemaId;
	 private Integer status;
	
	public Integer getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ShowtimesDTO [showtimeId=" + showtimeId + ", movieId=" + movieId + ", roomId=" + roomId + ", date="
				+ date + ", period=" + period + ", employeeId=" + employeeId + ", cinemaId=" + cinemaId + ", status="
				+ status + "]";
	}
	
	public boolean isNull(boolean includeId) {
        boolean res = isNull(movieId) || isNull(roomId) || isNull(period) || isNull(employeeId) || isNull(cinemaId) || isNull(status) ;
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
        if(isNull(status)){
            showtime.setStatus(1);
        }
        return showtime;
    }
    public ShowtimesDTO() {
    	
    }
	 
}
