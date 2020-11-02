package com.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Entity.SeatStatus;

@Repository
public interface SeatStatusRepository extends JpaRepository<SeatStatus, Integer> {
	
}
