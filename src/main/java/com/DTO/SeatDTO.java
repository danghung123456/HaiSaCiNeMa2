package com.DTO;

<<<<<<< HEAD
=======
import com.Entity.Room;
>>>>>>> 6afbf360483d921cdd3533b8d03d15c40e343080
import com.Entity.Seat;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SeatDTO {
	private Integer seatId;
	private String seatName;
	private Integer roomId;
<<<<<<< HEAD
	
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
=======
	private Room room;

	public SeatDTO() {
		super();
	}

	public SeatDTO(Integer seatId, String seatName, Integer roomId) {
		super();
		this.seatId = seatId;
		this.seatName = seatName;
		this.roomId = roomId;
	}

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
		Room room = new Room();
		room.setRoomId(this.getRoomId());
		this.setRoom(room);
		ObjectMapper mapper = new ObjectMapper();
		Seat seat = mapper.convertValue(this, Seat.class);
		return seat;
>>>>>>> 6afbf360483d921cdd3533b8d03d15c40e343080
	}

	public Integer getSeatId() {
		return seatId;
	}

<<<<<<< HEAD
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
//    	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	Seat seat = mapper.convertValue(this, Seat.class);
    	System.out.println("this is seat: "+seat.toString());
    	return seat;
    }
=======
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

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "SeatDTO [seatId=" + seatId + ", seatName=" + seatName + ", room=" + room + "]";
	}

>>>>>>> 6afbf360483d921cdd3533b8d03d15c40e343080
}
