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
public interface ShomtimesRepository extends JpaRepository<Showtimes, Integer> {

	@Query("FROM Showtimes s WHERE s.status = 1")
	Page<Showtimes> findAllShowtimes(Pageable pageable);

	@Query("FROM  Showtimes s WHERE s.showtimeId = :id AND s.status = 1")
	Optional<Showtimes> findByShowtimesId(Integer id);


<<<<<<< HEAD
	@Query(value = "SELECT * FROM Showtimes s WHERE s.movieName LIKE %?% AND m.status = 1", nativeQuery = true)
	List<Showtimes> findByName(String name);
=======
>>>>>>> Fix
}
