package com.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.Entity.Food;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public interface FoodService {
	/**
	 * Find all entity Food with status entered
	 * 
	 * @return List<Food>
	 */
	List<Food> getAllByStatus(Integer st);

	/**
	 * Find all entity Food
	 * 
	 * @return List<Food>
	 */
	List<Food> getAllFood();

	/**
	 * Delete all entity Food already exists
	 * 
	 * @return void
	 */
	void deleteAll();

	/**
	 * Saves a entity Food
	 * 
	 * @return Food
	 */
	Food add(Food food);

	/**
	 * Saves all entity Food from list Food
	 * 
	 * @return List<Food>
	 */
	List<Food> addAll(List<Food> list);

	/**
	 * Search a entity Food by its id
	 * 
	 * @return the entity with the FoodId entered or Optional#empty() if none found.
	 */
	Optional<Food> findById(Integer id);

<<<<<<< HEAD
	/**
	 * Search list Foof with the same name(foodName) entered
	 * 
	 * @return List<Food>
	 */
	List<Food> findByName(String name);
=======
	List<Food> findByName(String name, Integer status);
>>>>>>> bdcd4ea57cfee0eff01478f49a4a2f4c424c62a7

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity Food
	 */
	Food save(Food food);

}
