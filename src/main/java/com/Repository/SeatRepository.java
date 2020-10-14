package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
	
	@Query("from Seat s where s.seatId = :id ")
	Optional<Seat> findBySeatId(Integer id);

	@Query(value = "select * from Seat s where s.name = :name", nativeQuery = true)
	List<Seat> findBySeatName(String name);
}
