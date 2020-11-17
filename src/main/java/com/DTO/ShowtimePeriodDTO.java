package com.DTO;

public class ShowtimePeriodDTO {
	private Integer showtimeId;
	private Integer periodId;
	private String startTime;
	private Integer statusDay;
	private Float price;

	public ShowtimePeriodDTO() {
		super();
	}

	public ShowtimePeriodDTO(Integer showtimeId, Integer periodId, String startTime, Integer statusDay, Float price) {
		super();
		this.showtimeId = showtimeId;
		this.periodId = periodId;
		this.startTime = startTime;
		this.statusDay = statusDay;
		this.price = price;
	}

	public Integer getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}

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

}
