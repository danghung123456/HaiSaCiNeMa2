package com.DTO;

import java.util.Date;
import java.util.List;

import com.Entity.Period;

public class DatePeriodDTO {
	private Date date;
	private List<Period> periods;

	public DatePeriodDTO() {
		super();
	}

	public DatePeriodDTO(Date date, List<Period> periods) {
		super();
		this.date = date;
		this.periods = periods;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

}
