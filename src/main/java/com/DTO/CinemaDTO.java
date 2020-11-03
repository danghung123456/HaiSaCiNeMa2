package com.DTO;

import com.Entity.Cinema;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CinemaDTO {
	private Integer cinemaId;
	private String name;
	private String address;

<<<<<<< HEAD
	public CinemaDTO() {

	}

	public CinemaDTO(Integer cinemaId, String name, String address) {
		super();
		this.cinemaId = cinemaId;
		this.name = name;
		this.address = address;

		System.out.println("sadasdasdsadsadassd");
System.out.println("asdsadsad");
		
=======
	@Override
	public String toString() {
		return "CinemaDTO [cinemaId=" + cinemaId + ", name=" + name + ", address=" + address + "]";
>>>>>>> 436b74f030f0c7c2ae6c46a85fa9937e17d0e164
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

	public CinemaDTO(Integer cinemaId, String name, String address) {
		super();
		this.cinemaId = cinemaId;
		this.name = name;
		this.address = address;
	}

	public CinemaDTO() {

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

}
