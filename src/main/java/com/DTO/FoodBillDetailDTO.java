package com.DTO;

import com.Entity.Food;
import com.Entity.FoodBillDetail;
import com.Entity.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FoodBillDetailDTO {

	private Integer foodBillDetailId;
	private Ticket ticket;
	private Food food;
	private Integer quantity;
	private Float amount;

	public boolean isNull(boolean includeId) {
		boolean res = isNull(quantity) || isNull(amount) || isNull(ticket.getTicketId()) || isNull(food.getFoodId());
		return includeId ? res || isNull(foodBillDetailId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	private boolean isNull(Float input) {
		return input == null;
	}

	public FoodBillDetail convertToFood() {
		ObjectMapper mapper = new ObjectMapper();
		FoodBillDetail foodBillDetail = mapper.convertValue(this, FoodBillDetail.class);
		return foodBillDetail;
	}

	public FoodBillDetailDTO() {
		super();
	}

	public FoodBillDetailDTO(Integer foodBillDetailId, Ticket ticket, Food food, Integer quantity, Float amount) {
		super();
		this.foodBillDetailId = foodBillDetailId;
		this.ticket = ticket;
		this.food = food;
		this.quantity = quantity;
		this.amount = amount;
	}

	public Integer getFoodBillDetailId() {
		return foodBillDetailId;
	}

	public void setFoodBillDetailId(Integer foodBillDetailId) {
		this.foodBillDetailId = foodBillDetailId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "FoodBillDetailDTO [foodBillDetailId=" + foodBillDetailId + ", ticket=" + ticket + ", food=" + food
				+ ", quantity=" + quantity + ", amount=" + amount + "]";
	}

}
