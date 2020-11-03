package com.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Constant.*;
import com.DTO.FoodDTO;
import com.DTO.Base.ResponseEntity;
import com.Entity.Food;
import com.Services.FoodService;


@RestController
@RequestMapping(value = "food")

public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@GetMapping
	public  ResponseEntity<List<Food>> index(Integer status) {
		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		return ResponseEntity.body(foodService.getAll(st));
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addFood(@RequestBody FoodDTO foodDTO){
		if (foodDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		}else {
			foodDTO.setFoodId(null);
			foodDTO.setStatus(1);
			Food food = foodDTO.convertToFood();
			return ResponseEntity.body(foodService.add(food));
		}
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<Object> updateFood(@RequestBody FoodDTO foodDTO) {
		if (foodDTO.isNull(true)) {
            return ResponseEntity.body(Constant.BAD_REQUEST);
        } else {
            Optional<Food> checkFood = foodService.findById(foodDTO.getFoodId());
            if (checkFood.isPresent()) {
            	Food food = foodDTO.convertToFood();
                return ResponseEntity.body(foodService.save(food));
            } else {
                return ResponseEntity.body(Constant.NOT_FOUND);
            }
        }
	}
	 
	@PutMapping(value = "/delete")
	public ResponseEntity<Object> deleteFood(@RequestBody FoodDTO foodDTO) {
		if (foodDTO.getFoodId() == null) {
            return ResponseEntity.body(Constant.BAD_REQUEST);
        } else {
            Optional<Food> checkMovie = foodService.findById(foodDTO.getFoodId());
            if (checkMovie.isPresent()) {
            	Food food = foodDTO.convertToFood();
            	food.setStatus(0);
                return ResponseEntity.body(foodService.save(food));
            } else {
                return ResponseEntity.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@GetMapping("/findbyid")
	public ResponseEntity<Object> findById(Integer id) {
		return  ResponseEntity.body(foodService.findById(id));
	}
	
	@GetMapping("/findbyname")
	public ResponseEntity<Object> findByName(String name) {
		return ResponseEntity.body(foodService.findByName(name));
	}
	
	
}
