package com.Entity;
// default package
// Generated Oct 11, 2020, 8:25:38 PM by Hibernate Tools 5.1.10.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Food generated by hbm2java
 */
@Entity
@Table(name = "Food")
public class Food  {

	private Integer foodId;
	private String name;
	private Double price;
	private Integer status;
	private Set<FoodBillDetail> foodBillDetails = new HashSet<FoodBillDetail>(0);

	public Food() {
	}

	public Food(String name, Double price, Integer status, Set<FoodBillDetail> foodBillDetails) {
		this.name = name;
		this.price = price;
		this.status = status;
		this.foodBillDetails = foodBillDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "foodId", unique = true, nullable = false)
	public Integer getFoodId() {
		return this.foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	@Column(name = "name")
	public Serializable getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", precision = 53, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
	public Set<FoodBillDetail> getFoodBillDetails() {
		return this.foodBillDetails;
	}

	public void setFoodBillDetails(Set<FoodBillDetail> foodBillDetails) {
		this.foodBillDetails = foodBillDetails;
	}

}
