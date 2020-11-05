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

	@Query(value = "SELECT t.showtimes.movie.movieId, t.showtimes.movie.movieName as movieName, Month(t.showtimes.date) as month, SUM(t.ticketQuantity) as ticketQuantity "
			+ "FROM Ticket t "
			+ "GROUP BY t.showtimes.movie.movieId, Month(t.showtimes.date), t.showtimes.movie.movieName")
	List<TicketByMovieView> getTicketByMovie();

	@Query(value = "SELECT t.showtimes.room.cinema.name as cinemaName,  t.showtimes.period.startTime as startTime, SUM(t.ticketQuantity) as ticketQuantity "
			+ "FROM Ticket t "
			+ "GROUP BY t.showtimes.period.periodId, t.showtimes.room.cinema.cinemaId, t.showtimes.room.cinema.name, t.showtimes.period.startTime")
	List<TicketByShowtimeView> getTicketByShowtime();
	
	@Query(value = "SELECT f.ticket.showtimes.room.cinema.name as cinemaName, MONTH(f.ticket.showtimes.date) as month, SUM(f.ticket.ticketPriceAmount) as totalTicket, SUM(f.total) as totalFood, SUM(f.ticket.total) as total "
			+ "FROM FoodBillDetail f "
			+ "GROUP BY f.ticket.showtimes.room.cinema.name, f.ticket.showtimes.room.cinema.cinemaId, MONTH(f.ticket.showtimes.date) ")
	List<TotalByCinemaView> getTotalByCinema();
	
}
