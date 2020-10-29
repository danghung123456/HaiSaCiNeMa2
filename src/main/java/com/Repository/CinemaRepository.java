package com.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Entity.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

	@Query(value = "SELECT * FROM Cinema c WHERE c.name LIKE %?% ", nativeQuery = true)
	List<Cinema> findByNames(String name);
}
