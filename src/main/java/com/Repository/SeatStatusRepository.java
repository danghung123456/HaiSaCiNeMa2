package com.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;

@Repository
public interface SeatStatusRepository extends JpaRepository<SeatStatus, Integer> {
	
	@Procedure
	Page<Showtimes> findShowtimesByStatus(Integer status, Pageable pageable);
}
