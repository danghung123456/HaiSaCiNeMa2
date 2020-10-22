package com.DTO;

import com.Entity.Room;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RoomDTO {

	private Integer roomID;
	private Integer roomName;
	private Integer seatAmount;
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
	
	@Override
	public String toString() {
		return "RoomDTO [roomID=" + roomID + ", roomName=" + roomName + ", seatAmount=" + seatAmount + ",cinemaId= "
				+ cinemaId +"]";
	}
	
	private boolean isNull(String input) {
        return input == null || input.trim().length() == 0;
    }

    private boolean isNull(Integer input) {
        return input == null;
    }
    
    public boolean isNull(boolean includeId) {
        boolean res = isNull(roomName)|| isNull(seatAmount)||isNull(cinemaId);
        return includeId ? res || isNull(roomID) : res;
    }
    
    public Room convertToRoom() {
        ObjectMapper mapper = new ObjectMapper();
        Room room = mapper.convertValue(this, Room.class);
//        if(isNull(status)){
//            movie.setStatus(1);
//        }
        return room;
    }
    public RoomDTO() {
    	
    }
	
}
