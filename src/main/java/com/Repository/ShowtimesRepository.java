package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Entity.Showtimes;

@Repository
public interface ShowtimesRepository extends JpaRepository<Showtimes, Integer> {

	@Query("FROM Showtimes s WHERE s.status = :status")
	List<Showtimes> findShowtimesByStatus(Integer status);

	@Query("FROM  Showtimes s WHERE s.showtimeId = :id AND s.status = 1")
	Optional<Showtimes> findByShowtimesId(Integer id);

	@Query(value = "SELECT s FROM Showtimes s WHERE s.movie.movieName LIKE %:name% AND s.status = 1")
	List<Showtimes> findByName(String name);

}
