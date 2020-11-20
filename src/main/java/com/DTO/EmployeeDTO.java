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
	private String phone;
	private String address;
	private Date birthday;
	private String idCard;
	private Integer cinemaId;
	private Integer status;

	public EmployeeDTO() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", name=" + name + ", password=" + password + ", role=" + role
				+ ", email=" + email + ",phone=" + phone + ",address=" + address + ",birthday=" + birthday + ",idCard="
				+ idCard + ",cinemaId=" + cinemaId + ",status=" + status + "]";
	}

	public EmployeeDTO(Integer employeeId, String name, String password, Integer role, String email, String phone,
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
		boolean res = isNull(name) || isNull(password) || isNull(role) || isNull(email) || isNull(phone)
				|| isNull(address) || isNull(cinemaId) || isNull(idCard);
		return includeId ? res || isNull(employeeId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public Employee convertToEmployee() {
		Employee employee = new Employee();
		Cinema cinema = new Cinema();
		cinema.setCinemaId(this.getCinemaId());
		employee.setCinema(cinema);
		employee.setEmployeeId(this.getEmployeeId());
		employee.setName(this.getName());
		employee.setEmail(this.getEmail());
		employee.setPassword(this.getPassword());
		employee.setBirthday(this.getBirthday());
		employee.setPhone(this.getPhone());
		employee.setIdCard(this.getIdCard());
		employee.setAddress(this.getAddress());
		employee.setRole(this.getRole());
		employee.setStatus(1);
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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

}
