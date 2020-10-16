package com.DTO;



import com.Entity.Period;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PeriodDTO {
	private Integer periodId;
	private String startTime;
	private Integer statusDay;
	private float price;
	
	
	
	@Override
	public String toString() {
		return "PeriodDTO [periodId=" + periodId + ", startTime=" + startTime + ", statusDay=" + statusDay + ", price="
				+ price + "]";
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isNull(boolean includeId) {
        boolean res = isNull(startTime) || isNull(statusDay) ;
        return includeId ? res || isNull(periodId) : res;
    }

    private boolean isNull(String input) {
        return input == null || input.trim().length() == 0;
    }

    private boolean isNull(Integer input) {
        return input == null;
    }
	
    public Period convertToPeriod() {
        ObjectMapper mapper = new ObjectMapper();
        Period period = mapper.convertValue(this, Period.class);
//        if(isNull(status)){
//            movie.setStatus(1);
//        }
        return period;
    }
    public PeriodDTO() {
    	
    }
}
