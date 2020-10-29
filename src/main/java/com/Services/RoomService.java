package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Room;


@Service
public interface RoomService {

	 	public Page<Room> getAll(Pageable pageable);

	    public void deleteAll();

	    public Room add(Room room);

	    public List<Room> addAll(List<Room> list);
	    
	    public Optional<Room> findById(Integer id);
	    
	    public List<Room> findByName(String name);

	    public Room save(Room room);
}
