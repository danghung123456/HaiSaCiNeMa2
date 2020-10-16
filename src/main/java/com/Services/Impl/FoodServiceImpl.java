
package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Food;
import com.Repository.FoodRepository;
import com.Services.FoodService;



@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodRepository repository;
	
	@Override
	public Page<Food> getAll(Pageable pageable) {
		
		return repository.findAll(pageable);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}

	@Override
	public Food add(Food food) {
	
		return repository.save(food);
	}

	@Override
	public List<Food> addAll(List<Food> list) {
		List<Food> res = new ArrayList<>();
		for(Food food: list) {
			res.add(add(food));
		}
		return res;
	}

	@Override
	public Optional<Food> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Food> findByName(String name) {
		return repository.findByFoodName(name);
	}

	@Override
	public Food save(Food food) {
		return repository.saveAndFlush(food);
	}

	@Override
	public Page<Food> findFoodByStatus(Integer status, Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findFoodByStatus(status, pageable);
	}

	
	
}


