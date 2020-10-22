package com.DTO;

import com.Entity.Cinema;
import com.Entity.Room;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RoomDTO {

	private Integer roomID;
	private Integer roomName;
	private Integer seatAmount;
	private Cinema cinema;

	public RoomDTO() {

	}

	public RoomDTO(Integer roomID, Integer roomName, Integer seatAmount, Cinema cinema) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.seatAmount = seatAmount;
		this.cinema = cinema;
	}

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

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public String toString() {
		return "RoomDTO [roomID=" + roomID + ", roomName=" + roomName + ", seatAmount=" + seatAmount + ", cinema="
				+ cinema + "]";
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(roomName) || isNull(seatAmount) || isNull(cinema.getCinemaId());
		return includeId ? res || isNull(roomID) : res;
	}

	public Room convertToRoom() {
		ObjectMapper mapper = new ObjectMapper();
		Room room = mapper.convertValue(this, Room.class);
		return room;
	}

}
