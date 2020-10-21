package com.DTO;

import com.Entity.Seat;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SeatDTO {
	private Integer seatId;
	private String seatName;
	private Integer roomId;
	
	public Integer getSeatId() {
		return seatId;
	}

	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public boolean isNull(boolean includeId) {
        boolean res = isNull(seatName) || isNull(roomId) ;
        return includeId ? res || isNull(seatId) : res;
    }

    private boolean isNull(String input) {
        return input == null || input.trim().length() == 0;
    }

    private boolean isNull(Integer input) {
        return input == null;
    }
    public Seat convertToDTO() {
    	ObjectMapper mapper = new ObjectMapper();
    	Seat seat = mapper.convertValue(this, Seat.class);
    	return seat;
    }
}
