
package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Room;
import com.Repository.RoomRepository;
import com.Services.RoomService;



@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository repository;
	

	@Override
	public Room add(Room room) {
		return repository.save(room);
	}

//	@Override
//	public List<Room> addAll(List<Room> list) {
//		 List<Room> res = new ArrayList<>();
//	        for (Room room : list){
//	            res.add(add(room));
//	        }
//	        return res;
//
//	}

	@Override
	public Optional<Room> findById(Integer id) {
		
		return repository.findById(id);
	}

	@Override
	public List<Room> findByName(String name) {
		return repository.findByRoomName(name);
	}

	@Override
	public Room save(Room room) {
		return repository.saveAndFlush(room);
	}
}

