package com.Entity;
// default package

// Generated Oct 13, 2020, 8:28:21 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * FoodBillDetail generated by hbm2java
 */
@Entity
@Table(name = "foodbilldetail")
public class FoodBillDetail {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "foodbilldetail", unique = true, nullable = false)
	Integer foodBillDetail;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "foodid")
	Food food;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ticketid")
	Ticket ticket;

	@Column(name = "quantity")
	Integer quantity;

	@Column(name = "total")
	Float total;

	public FoodBillDetail() {
	}

	public Integer getFoodBillDetail() {
		return foodBillDetail;
	}

	public void setFoodBillDetail(Integer foodBillDetail) {
		this.foodBillDetail = foodBillDetail;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

}
