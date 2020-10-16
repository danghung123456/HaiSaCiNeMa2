package com.Entity;
// default package
// Generated Oct 13, 2020, 8:28:21 PM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Period generated by hbm2java
 */
@Entity
@Table(name = "period")
public class Period {
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "periodid", unique = true, nullable = false)
	Integer periodId;
	
	@Column(name = "starttime")
	String startTime;
	
	@Column(name = "statusday")
	Integer statusDay;

	@Column(name = "price")
	Float price;
	
	@JsonIgnore
	@OneToMany(mappedBy = "period")
	List<Showtimes> showtimes;

	public Integer getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Integer periodId) {
		this.periodId = periodId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getStatusDay() {
		return statusDay;
	}

	public void setStatusDay(Integer statusDay) {
		this.statusDay = statusDay;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<Showtimes> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<Showtimes> showtimes) {
		this.showtimes = showtimes;
	}
	
	

}
