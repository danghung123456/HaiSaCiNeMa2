package com.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DTO.view.GenreMovieView;
import com.DTO.view.HistoryTransView;
import com.DTO.view.StartTimeView;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
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
	
	@Query(value = "SELECT m.movie.movieName as movieName, m.genreMovie.name as genreName "
			+ "FROM MovieGenreDetail m "
			+ "WHERE m.movie.movieId = :id ")
	List<GenreMovieView> getGenreByMovieId(Integer id);
	
	@Query(value= "SELECT t.ticketId as ticketId, t.member.memberId as memberId,t.member.memberName as memberName, t.ticketQuantity as ticketQuantity,t.total as total,t.showtimes.movie.movieName as movieName,t.showtimes.employee.name as employeeName,t.showtimes.date as date,t.showtimes.room.roomName as room,t.showtimes.room.cinema.name as cinemaName,t.showtimes.period.startTime as showtime,t.ticketPriceAmount as ticketPrice "
			+ "FROM Ticket t "
			+ "WHERE t.member.memberId = :id")
	List<HistoryTransView> getTicketBought(Integer id);

	
	@Query(value="SELECT s.employee.cinema.cinemaId as cinemaId, s.employee.cinema.name as cinemaName,s.employee.cinema.address as address,s.period.periodId as periodId, s.period.startTime as startTime "
			+ "FROM Showtimes s "
			+ "WHERE s.movie.movieId = :id")
	List<StartTimeView> getStartTime(Integer id);
	
}
