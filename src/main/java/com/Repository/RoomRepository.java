
package com.Repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	@Query("FROM Room")
	Page<Room> findAllRoom(Pageable pageable);
	
	@Query(value = "SELECT * FROM Room WHERE r.roomName LIKE %?% ", nativeQuery = true)
	List<Room> findByRoomName(String name);
	
}



