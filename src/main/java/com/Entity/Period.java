package com.Entity;
// default package
// Generated Oct 11, 2020, 8:25:38 PM by Hibernate Tools 5.1.10.Final

import java.io.Serializable;
import java.sql.Time;
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
 * Period generated by hbm2java
 */
@Entity
@Table(name = "Period")
public class Period  {

	private Integer periodId;
	private Time startTime;
	private Integer statusDay;
	private Double price;
	private Set<Showtimes> showtimeses = new HashSet<Showtimes>(0);

	public Period() {
	}

	public Period(Time startTime, Integer statusDay, Double price, Set<Showtimes> showtimeses) {
		this.startTime = startTime;
		this.statusDay = statusDay;
		this.price = price;
		this.showtimeses = showtimeses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "periodId", unique = true, nullable = false)
	public Integer getPeriodId() {
		return this.periodId;
	}

	public void setPeriodId(Integer periodId) {
		this.periodId = periodId;
	}

	@Column(name = "startTime")
	public Serializable getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	@Column(name = "statusDay")
	public Integer getStatusDay() {
		return this.statusDay;
	}

	public void setStatusDay(Integer statusDay) {
		this.statusDay = statusDay;
	}

	@Column(name = "price", precision = 53, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "period")
	public Set<Showtimes> getShowtimeses() {
		return this.showtimeses;
	}

	public void setShowtimeses(Set<Showtimes> showtimeses) {
		this.showtimeses = showtimeses;
	}

}
