package com.DTO;

import com.Entity.Cinema;
import com.Entity.Food;
import com.Entity.FoodBillDetail;
import com.Entity.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FoodBillDetailDTO {

	private Integer foodBillDetailId;
	private Integer ticketId;
	private Integer foodId;
	private Integer quantity;
	private Float amount;
	private Ticket ticket;
	private Food food;

	public FoodBillDetailDTO() {
		super();
	}

	public FoodBillDetailDTO(Integer foodBillDetailId, Integer ticketId, Integer foodId, Integer quantity,
			Float amount) {
		super();
		this.foodBillDetailId = foodBillDetailId;
		this.ticketId = ticketId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.amount = amount;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(quantity) || isNull(amount) || isNull(ticketId) || isNull(foodId);
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
		Ticket ticket = new Ticket();
		ticket.setTicketId(this.getTicketId());
		this.ticket = ticket;
		Food food = new Food();
		food.setFoodId(this.getFoodId());
		this.food = food;
		ObjectMapper mapper = new ObjectMapper();
		FoodBillDetail foodBillDetail = mapper.convertValue(this, FoodBillDetail.class);
		return foodBillDetail;
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

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	@Override
	public String toString() {
		return "FoodBillDetailDTO [foodBillDetailId=" + foodBillDetailId + ", ticket=" + ticket + ", food=" + food
				+ ", quantity=" + quantity + ", amount=" + amount + "]";
	}

}
