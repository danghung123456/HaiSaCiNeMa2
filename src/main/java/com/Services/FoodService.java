package com.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.Entity.Food;

@Service
public interface FoodService {

	List<Food> getAllByStatus(Integer st);
	
	List<Food> getAllFood();

	void deleteAll();

	Food add(Food food);

	List<Food> addAll(List<Food> list);

	Optional<Food> findById(Integer id);

	List<Food> findByName(String name);

	Food save(Food food);

}
