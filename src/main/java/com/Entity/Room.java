package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roomid")
	private Integer roomID;
	@Column(name = "roomname")
	private Integer roomName;
	@Column(name = "seatamount")
	private Integer seatAmount;
	@Column(name = "cinemaid")
	private Integer cinemaId;
	
	public Integer getRoomID() {
		return roomID;
	}
	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}
	public Integer getRoomName() {
		return roomName;
	}
	public void setRoomName(Integer roomName) {
		this.roomName = roomName;
	}
	public Integer getSeatAmount() {
		return seatAmount;
	}
	public void setSeatAmount(Integer seatAmount) {
		this.seatAmount = seatAmount;
	}
	public Integer getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}


	
}
