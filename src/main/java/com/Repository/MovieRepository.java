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
	@Query("FROM Movie m WHERE m.status = 1")
	Page<Movie> findAll(Pageable pageable);

	@Query("FROM  Movie m WHERE m.movieId = :id AND m.status = 1")
	Optional<Movie> findById(Integer id);

	@Query(value = "SELECT * FROM Movie m WHERE m.movieName LIKE %?% AND m.status = 1", nativeQuery = true)
	List<Movie> findByName(String name);
}
