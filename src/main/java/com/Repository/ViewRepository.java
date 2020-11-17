package com.Repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DTO.view.GenreMovieView;
import com.DTO.view.HistoryTransView;
import com.DTO.view.TopMovieView;
import com.DTO.view.StartTimeView;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
import com.Entity.View;

@Repository
public interface ViewRepository extends JpaRepository<View, Integer> {

	@Query(value = "SELECT t.showtimes.movie.movieId, t.showtimes.movie.movieName as movieName, Month(t.showtimes.date) as month, SUM(t.ticketQuantity) as ticketQuantity, YEAR(t.showtimes.date) as year "
			+ "FROM Ticket t "
			+ "WHERE Month(t.showtimes.date) = :month AND YEAR(t.showtimes.date) = :year "
			+ "GROUP BY t.showtimes.movie.movieId, Month(t.showtimes.date), t.showtimes.movie.movieName, YEAR(t.showtimes.date) ")
	List<TicketByMovieView> getTicketOfMonthByMovie(Integer month, Integer year);
	
	@Query(value = "SELECT t.showtimes.movie.movieId, t.showtimes.movie.movieName as movieName, SUM(t.ticketQuantity) as ticketQuantity "
			+ "FROM Ticket t "
			+ "WHERE t.showtimes.movie.status = :status "
			+ "GROUP BY t.showtimes.movie.movieId, t.showtimes.movie.movieName")
	List<TicketByMovieView> getTicketByMovie(Integer status);

	@Query(value = "SELECT t.showtimes.room.cinema.name as cinemaName,  t.showtimes.period.startTime as startTime, SUM(t.ticketQuantity) as ticketQuantity "
			+ "FROM Ticket t "
			+ "WHERE t.showtimes.room.cinema.cinemaId = :id "
			+ "GROUP BY t.showtimes.period.periodId, t.showtimes.room.cinema.cinemaId, t.showtimes.room.cinema.name, t.showtimes.period.startTime")
	List<TicketByShowtimeView> getTicketByShowtime(Integer id);
	
	@Query(value = "SELECT f.ticket.showtimes.room.cinema.name as cinemaName, MONTH(f.ticket.showtimes.date) as month, SUM(f.ticket.ticketPriceAmount) as totalTicket, SUM(f.total) as totalFood, SUM(f.ticket.total) as total "
			+ "FROM FoodBillDetail f "
			+ "WHERE f.ticket.showtimes.room.cinema.cinemaId = :id "
			+ "GROUP BY f.ticket.showtimes.room.cinema.name, f.ticket.showtimes.room.cinema.cinemaId, MONTH(f.ticket.showtimes.date) ")
	List<TotalByCinemaView> getTotalOfMonthByCinema(Integer id);
	
	@Query(value= "SELECT t.showtimes.room.cinema.name as cinemaName, SUM(t.total) as total "
			+ "FROM Ticket t "
			+ "GROUP BY t.showtimes.room.cinema.name, t.showtimes.room.cinema.cinemaId ")
	List<TotalByCinemaView> getTotalByCinema();
	
	@Query(value = "SELECT m.movie.movieName as movieName, m.genreMovie.name as genreName "
			+ "FROM MovieGenreDetail m "
			+ "WHERE m.movie.movieId = :id ")
	List<GenreMovieView> getGenreByMovieId(Integer id);
	
	@Query(value= "SELECT t.ticket.ticketId as ticketId, t.ticket.member.memberId as memberId, t.ticket.member.memberName as memberName, t.ticket.ticketQuantity as ticketQuantity, t.ticket.total as total, t.ticket.showtimes.movie.movieName as movieName, t.ticket.showtimes.employee.name as employeeName, t.ticket.showtimes.date as date, t.ticket.showtimes.room.roomName as room, t.ticket.showtimes.room.cinema.name as cinemaName, t.ticket.showtimes.period.startTime as showtime, t.ticket.ticketPriceAmount as ticketPrice, SUM(t.total) as foodPrice "
			+ "FROM FoodBillDetail t "
			+ "WHERE t.ticket.member.memberId = :id "
			+ "GROUP BY t.ticket.member.memberId, t.ticket.ticketId, t.ticket.member.memberId, t.ticket.member.memberName, t.ticket.ticketQuantity, t.ticket.total, t.ticket.showtimes.movie.movieName, t.ticket.showtimes.employee.name, t.ticket.showtimes.date, t.ticket.showtimes.room.roomName, t.ticket.showtimes.room.cinema.name, t.ticket.showtimes.period.startTime, t.ticket.ticketPriceAmount")
	List<HistoryTransView> getTicketBought(Integer id);
	
	@Query(value= "SELECT t.showtimes.movie.movieId as movieId, t.showtimes.movie.movieName as movieName,t.showtimes.movie.thumbnail as thumbnail, SUM(t.ticketQuantity) "
			+ "FROM Ticket t "
			+ "WHERE t.showtimes.date BETWEEN  :dateNow AND :date "
			+ "GROUP BY t.showtimes.movie.movieId, t.showtimes.movie.movieName,t.showtimes.movie.thumbnail "
			+ "ORDER BY SUM(t.ticketQuantity) DESC ")
	List<TopMovieView> getTopMovie(Date date, Date dateNow);
	
}
