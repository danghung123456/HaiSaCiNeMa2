package com.DTO.view;

import java.util.Date;
import java.util.List;

public class DatePeriodDTO {
	private Date date;
	private List<ShowtimePeriodDTO> periods;

	public DatePeriodDTO() {
		super();
	}

	public DatePeriodDTO(Date date, List<ShowtimePeriodDTO> periods) {
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

	public List<ShowtimePeriodDTO> getPeriods() {
		return periods;
	}

	public void setPeriods(List<ShowtimePeriodDTO> periods) {
		this.periods = periods;
	}

}
