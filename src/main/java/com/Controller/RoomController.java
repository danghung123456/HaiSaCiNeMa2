package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.RoomDTO;
import com.DTO.Base.ResponseEntiy;
import com.Entity.Room;
import com.Services.RoomService;


@RestController
@RequestMapping(value = "room")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@GetMapping("/index")
	public  ResponseEntiy<List<Room>> index(Integer page) {
		List<Room> list;
		int pageSize = 5;
		if (page == null) {
			list = roomService.getAll(Pageable.unpaged()).getContent();
		} else {
			list = roomService.getAll(PageRequest.of(page, pageSize)).getContent();
		}
		return  ResponseEntiy.body(list);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntiy<Object> addRoom(@RequestBody RoomDTO roomDTO) {
		 if (roomDTO.isNull(false)) {
	            return ResponseEntiy.body(Constant.BAD_REQUEST);
	        } else {
	            //Make sure id is NULL to insert Entity
	        	roomDTO.setRoomID(null);
	            Room room = roomDTO.convertToRoom();
	            return ResponseEntiy.body(roomService.add(room));
	        }
	}
	
	@PutMapping(value = "/update")
	public ResponseEntiy<Object> updateRoom(@RequestBody RoomDTO roomDTO) {
		if (roomDTO.isNull(true)) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Room> checkRoom = roomService.findById(roomDTO.getRoomID());
            if (checkRoom.isPresent()) {
                Room room = roomDTO.convertToRoom();
                return ResponseEntiy.body(roomService.save(room));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntiy<Object> deleteRoom(@RequestBody RoomDTO roomDTO) {
		if (roomDTO.getRoomID() == null) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Room> checkRoom = roomService.findById(roomDTO.getRoomID());
            if (checkRoom.isPresent()) {
            	Room room = roomDTO.convertToRoom();
//            	movie.setStatus(0);
                return ResponseEntiy.body(roomService.save(room));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@GetMapping("/findbyid")
	public ResponseEntiy<Object> findById(Integer id) {
		return  ResponseEntiy.body(roomService.findById(id));
	}
	
	@GetMapping("/findbyname")
	public ResponseEntiy<Object> findByName(String name) {
		return ResponseEntiy.body(roomService.findByName(name));
	}
	
	
}
