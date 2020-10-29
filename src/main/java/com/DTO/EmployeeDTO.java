	package com.DTO;

import java.sql.Date;

import com.Entity.Cinema;
import com.Entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeDTO {
	private Integer employeeId;
	private String name;
	private String password;
	private Integer role;
	private String email;
	private Integer phone;
	private String address;
	private Date birthday;
	private String idCard;
	private Integer cinemaId;
	private Integer status;
	private Cinema cinema;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(Integer employeeId, String name, String password, Integer role, String email, Integer phone,
			String address, Date birthday, String idCard, Integer cinemaId, Integer status) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.password = password;
		this.role = role;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		this.idCard = idCard;
		this.cinemaId = cinemaId;
		this.status = status;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(name) || isNull(password) || isNull(email) || isNull(phone) || isNull(address)
				|| isNull(idCard) || isNull(cinemaId);
		return includeId ? res || isNull(employeeId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public Employee convertToEmployee() {
		Cinema cinema = new Cinema();
		cinema.setCinemaId(this.getCinemaId());
		this.setCinema(cinema);
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = mapper.convertValue(this, Employee.class);
		if (isNull(status)) {
			employee.setStatus(1);
		}
		return employee;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

}
