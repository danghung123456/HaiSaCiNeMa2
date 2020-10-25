package com.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Entity.Food;

@Service
public interface FoodService {

	public List<Food> getAll();

	public void deleteAll();

	public Food add(Food food);

	public List<Food> addAll(List<Food> list);

	public Optional<Food> findById(Integer id);

	public List<Food> findByName(String name);

	public Food save(Food food);

	public Page<Food> findFoodByStatus(Integer status, Pageable pageable);

}
