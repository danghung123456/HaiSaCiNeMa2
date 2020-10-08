package com.DTO;

import com.Entity.Cinema;
import com.Entity.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CinemaDTO {
	private Integer cinemaId;
	private String name;
	private String address;
	public Integer getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CinemaDTO [cinemaId=" + cinemaId + ", name=" + name + ", address=" + address + "]";
	}
	
	public boolean isNull(boolean includeId) {
        boolean res = isNull(name) || isNull(address) ;
        return includeId ? res || isNull(cinemaId) : res;
    }

    private boolean isNull(String input) {
        return input == null || input.trim().length() == 0;
    }

    private boolean isNull(Integer input) {
        return input == null;
    }
	
    public Cinema convertToCinema() {
        ObjectMapper mapper = new ObjectMapper();
        Cinema cinema = mapper.convertValue(this, Cinema.class);
//        if(isNull(status)){
//            movie.setStatus(1);
//        }
        return cinema;
    }
    public CinemaDTO() {
    	
    }
}