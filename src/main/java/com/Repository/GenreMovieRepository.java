package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Entity.GenreMovie;

public interface GenreMovieRepository extends JpaRepository<GenreMovie, Integer> {
	@Query("from GenreMovie")
	Page<GenreMovie> findAll(Pageable pageable);

	@Query("from GenreMovie g where g.genreId = :id")
	Optional<GenreMovie> findById(Integer id);
	
	@Query(value = "select * from GenreMovie g where g.name = :name",nativeQuery = true)
	List<GenreMovie> findByName(String name);
}
