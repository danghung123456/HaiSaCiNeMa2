package com.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Constant.*;
import com.DTO.FoodDTO;
import com.DTO.Base.ResponseEntiy;
import com.Entity.Food;
import com.Services.FoodService;


@RestController
@RequestMapping(value = "food")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@GetMapping("/index")
	public  ResponseEntiy<Page<Food>> index(Integer status ,Integer page) {
		Page<Food> list;
		//1 trang có 5 food
		int pageSize = 5;
		//Tìm danh sách food theo status(status: 0: khong con, 1: đang co)
		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		if (page == null) {
			list = foodService.findFoodByStatus(st, Pageable.unpaged());
		} else {
			list = foodService.findFoodByStatus(st, PageRequest.of(page, pageSize));
		}
		return  ResponseEntiy.body(list);
	}
	
	@PostMapping("/add")
	public ResponseEntiy<Object> addFood(@RequestBody FoodDTO foodDTO){
		if (foodDTO.isNull(false)) {
			return ResponseEntiy.body(Constant.BAD_REQUEST);
		}else {
			foodDTO.setFoodId(null);
//			foodDTO.setStatus(1);
			Food food = foodDTO.convertToFood();
			return ResponseEntiy.body(foodService.add(food));
		}
	}
	
	@PutMapping(value = "/update")
	public ResponseEntiy<Object> updateFood(@RequestBody FoodDTO foodDTO) {
		if (foodDTO.isNull(true)) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Food> checkFood = foodService.findById(foodDTO.getFoodId());
            if (checkFood.isPresent()) {
            	Food food = foodDTO.convertToFood();
                return ResponseEntiy.body(foodService.save(food));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	 
	@PutMapping(value = "/delete")
	public ResponseEntiy<Object> deleteFood(@RequestBody FoodDTO foodDTO) {
		if (foodDTO.getFoodId() == null) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Food> checkMovie = foodService.findById(foodDTO.getFoodId());
            if (checkMovie.isPresent()) {
            	Food food = foodDTO.convertToFood();
            	food.setStatus(0);
                return ResponseEntiy.body(foodService.save(food));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@GetMapping("/findbyid")
	public ResponseEntiy<Object> findById(Integer id) {
		return  ResponseEntiy.body(foodService.findById(id));
	}
	
	@GetMapping("/findbyname")
	public ResponseEntiy<Object> findByName(String name) {
		return ResponseEntiy.body(foodService.findByName(name));
	}
	
	
}
