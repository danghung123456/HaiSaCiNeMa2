package com.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	@Query("FROM Movie m WHERE m.status = :status")
	List<Movie> findMovieByStatus(Integer status);

	@Query(value = "SELECT m FROM Movie m WHERE m.movieName LIKE %:name%")
	List<Movie> findByMovieName(String name);
	
	@Query(value = "SELECT COUNT(m) FROM Movie m")
	Integer totalMovie();
	
	@Query(value ="SELECT s.movie.movieId "
			+ "FROM Showtimes s "
			+ "WHERE s.date BETWEEN :startDate AND :endDate "
			+ "GROUP BY s.movie.movieId")
	List<Integer> findMovieByNextDay(Date startDate, Date endDate);
}
