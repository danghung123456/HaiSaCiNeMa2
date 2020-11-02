package com.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
import com.Entity.Cinema;
import com.Entity.View;

@Repository
public interface ViewRepository extends JpaRepository<View, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM amountTicketofMovie")
	List<TicketByMovieView> getTicketByMovie();

	@Query(nativeQuery = true, value = "SELECT * FROM amountTicketofShowtime")
	List<TicketByShowtimeView> getTicketByShowtime();
	
	@Query(nativeQuery = true, value = "SELECT * FROM totalCinemaMonth")
	List<TotalByCinemaView> getTotalByCinema();
	
	
	
}
