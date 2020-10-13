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

<<<<<<< HEAD
//	@Query("FROM Room")
//	Page<Room> findAll(Pageable pageable);
//	
//	@Query("FROM Room r WHERE r.roomID= :id")
//	Optional<Room> findById(Integer id);
=======
	@Query("FROM Room")
	Page<Room> findAll(Pageable pageable);
	
	@Query("FROM Room r WHERE r.roomId= :id")
	Optional<Room> findById(Integer id);
>>>>>>> 77eea5eb881e7a6d007a5a66397687eda02c6c8f
	
	@Query(value = "SELECT * FROM Room WHERE r.roomName LIKE %?% ", nativeQuery = true)
	List<Room> findByName(String name);
	
}
