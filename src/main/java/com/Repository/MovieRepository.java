package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	@Query("FROM Movie m WHERE m.status = :status")
	Page<Movie> findMovieByStatus(Integer status ,Pageable pageable);

	@Query("FROM  Movie m WHERE m.movieId = :id")
	Optional<Movie> findByMovieId(Integer id);

	@Query(value = "SELECT m FROM Movie m WHERE m.movieName LIKE %:name%")
	List<Movie> findByMovieName(String name);
	
	
	
}
