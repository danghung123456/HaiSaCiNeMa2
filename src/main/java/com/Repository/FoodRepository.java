//package com.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.Entity.Food;
//
//@Repository
//public interface FoodRepository extends JpaRepository<Food, Integer> {
//
//	@Query("FROM Food f WHERE f.status = 1")
//	Page<Food> findAll(Pageable pageable);
//	
//	@Query("FROM Food f WHERE f.foodId = :id AND f.status = 1")
//	Optional<Food> findById(Integer id);
//	
//	@Query(value = "SELECT * FROM Food f WHERE f.name LIKE %?% AND f.status = 1",nativeQuery = true)
//	List<Food> findByName(String name);
//	
//}
