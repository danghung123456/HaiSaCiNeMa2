package com.Entity;
// default package
// Generated Oct 11, 2020, 8:25:38 PM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Room generated by hbm2java
 */
@Entity
@Table(name = "Room")
public class Room  {

	private Integer roomId;
	private Cinema cinema;
	private Integer roomName;
	private Integer seatAmount;
	private Set<Seat> seats = new HashSet<Seat>(0);
	private Set<Showtimes> showtimeses = new HashSet<Showtimes>(0);

	public Room() {
	}

	public Room(Cinema cinema, Integer roomName, Integer seatAmount, Set<Seat> seats, Set<Showtimes> showtimeses) {
		this.cinema = cinema;
		this.roomName = roomName;
		this.seatAmount = seatAmount;
		this.seats = seats;
		this.showtimeses = showtimeses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "roomId", unique = true, nullable = false)
	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cinemaId")
	public Cinema getCinema() {
		return this.cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	@Column(name = "roomName")
	public Integer getRoomName() {
		return this.roomName;
	}

	public void setRoomName(Integer roomName) {
		this.roomName = roomName;
	}

	@Column(name = "seatAmount")
	public Integer getSeatAmount() {
		return this.seatAmount;
	}

	public void setSeatAmount(Integer seatAmount) {
		this.seatAmount = seatAmount;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
	public Set<Seat> getSeats() {
		return this.seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
	public Set<Showtimes> getShowtimeses() {
		return this.showtimeses;
	}

	public void setShowtimeses(Set<Showtimes> showtimeses) {
		this.showtimeses = showtimeses;
	}

}
