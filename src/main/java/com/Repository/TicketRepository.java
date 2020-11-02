package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.DTO.view.TicketByCinemaView;
import com.DTO.view.TicketByShowtimeView;
import com.Entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query("FROM Ticket t WHERE t.code = :code")
	Ticket findTicketByCode(String code);

	@Query(nativeQuery = true, value = "SELECT * FROM amountTicketofCinema")
	List<TicketByCinemaView> getTicketByCinema();

	@Query(nativeQuery = true, value = "SELECT * FROM amountTicketofShowtime")
	List<TicketByShowtimeView> getTicketByShowtime();

}
