package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DTO.ViewDTO;
import com.Entity.Showtimes;

@Repository
public interface ShowtimesRepository extends JpaRepository<Showtimes, Integer> {

	@Query("FROM Showtimes s WHERE s.status = :status")
	Page<Showtimes> findShowtimesByStatus(Integer status, Pageable pageable);

	@Query("FROM  Showtimes s WHERE s.showtimeId = :id AND s.status = 1")
	Optional<Showtimes> findByShowtimesId(Integer id);

	@Query(value = "SELECT * FROM Showtimes s WHERE s.movieName LIKE %?% AND m.status = 1", nativeQuery = true)
	List<Showtimes> findByName(String name);

	@Query(nativeQuery = true, value = "select * from showMovie")
	List<ViewDTO> getViewShowTimes();
}
