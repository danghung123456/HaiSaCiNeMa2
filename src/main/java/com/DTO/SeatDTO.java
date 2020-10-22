package com.DTO;

import com.Entity.Room;
import com.Entity.Seat;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SeatDTO {
	private Integer seatId;
	private String seatName;
	private Room room;

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(seatName) || isNull(room.getRoomId());
		return includeId ? res || isNull(seatId) : res;
	}

	public Seat convertToRoom() {
		ObjectMapper mapper = new ObjectMapper();
		Seat seat = mapper.convertValue(this, Seat.class);
		return seat;
	}

	public SeatDTO() {
		super();
	}

	public SeatDTO(Integer seatId, String seatName, Room room) {
		super();
		this.seatId = seatId;
		this.seatName = seatName;
		this.room = room;
	}

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "SeatDTO [seatId=" + seatId + ", seatName=" + seatName + ", room=" + room + "]";
	}

}
