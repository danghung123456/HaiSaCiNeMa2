package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.Entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	@Query("FROM Room")
	Page<Room> findAll(Pageable pageable);
	
	@Query("FROM Room r WHERE r.roomId= :id")
	Optional<Room> findById(Integer id);
	
	@Query(value = "SELECT * FROM Room WHERE r.roomName LIKE %?% ", nativeQuery = true)
	List<Room> findByName(String name);
	
}
