package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Cinema;



@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
	@Query("FROM Cinema ")
	Page<Cinema> findAll(Pageable pageable);
	
	@Query("FROM  Cinema c WHERE c.cinemaId = :id")
	Optional<Cinema> findById(Integer id);
	
	@Query(value = "SELECT * FROM Cinema c WHERE c.name LIKE %?% ", nativeQuery = true)
	List<Cinema> findByNames(String name);
}
