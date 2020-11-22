package com.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.Entity.Room;

@Service
public interface RoomService {

	List<Room> getAll();

	Room add(Room room);

	Optional<Room> findById(Integer id);

	List<Room> findByName(String name);

	Room save(Room room);
}
