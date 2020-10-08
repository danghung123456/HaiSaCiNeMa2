package com.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="showtimes")
public class Showtimes {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="showtimeid")
	    private Integer showtimeId;
	    
	    @Column(name = "movieid")
	    private Integer movieId;
	    
	    @Column(name="roomid")
	    private Integer roomId;
	    
	    @Column(name="date")
	    private Date date;
	    
	    @Column(name="period")
	    private Integer period;
	    
	    @Column(name="employeeid")
	    private Integer employeeId;
	    
	    @Column(name="cinemaid")
	    private Integer cinemaId;
	    
	    @Column(name="status")
	    private Integer status;

		public Integer getShowtimeId() {
			return showtimeId;
		}

		public void setShowtimeId(Integer showtimeId) {
			this.showtimeId = showtimeId;
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

		
	    
	    
}
