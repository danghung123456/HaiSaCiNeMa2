package com.DTO;

import com.Entity.Cinema;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CinemaDTO {
	private Integer cinemaId;
	private String name;
	private String address;

	public CinemaDTO() {

	}

	public CinemaDTO(Integer cinemaId, String name, String address) {
		super();
		this.cinemaId = cinemaId;
		this.name = name;
		this.address = address;
		System.out.println("LOL");
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(name) || isNull(address);
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
		return cinema;
	}

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

}
