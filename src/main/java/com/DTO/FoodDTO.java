package com.DTO;


import com.Entity.Food;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FoodDTO {

	private Integer foodId;
	private String name;
	private Double price;
	private Integer status;
	
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "FoodDTO [foodId=" + foodId + ", name=" + name + ", price=" + price + ", status="
				+ status +"]";
	}
	
	public boolean isNull(boolean includeId) {
        boolean res = isNull(name);
        return includeId ? res || isNull(foodId) : res;
    }
	
	private boolean isNull(String input) {
        return input == null || input.trim().length() == 0;
    }

    private boolean isNull(Integer input) {
        return input == null;
    }
    
	public Food convertToFood() {
		ObjectMapper mapper = new ObjectMapper();
		Food food = mapper.convertValue(this, Food.class);
		if (isNull(status)) {
			food.setStatus(1);
		}
		return food;
	}
	
	
}
