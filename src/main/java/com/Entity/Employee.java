package com.Entity;
// default package
// Generated Oct 13, 2020, 8:28:21 PM by Hibernate Tools 5.1.10.Final


import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "employee")
public class Employee  {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "employeeid", unique = true, nullable = false)
	Integer employeeId;

	@Column(name = "name")
	String name;

	@Column(name = "password")
	String password;

	@Column(name = "role")
	int role;

	@Column(name = "email")
	String email;

	@Column(name = "phone")
	String  phone;

	@Column(name = "address")
	String address;

	@Column(name = "birthday")
	Date birthday;

	@Column(name = "idcard")
	String idCard;

	@Column(name = "status")
	Integer status;
	
	@ManyToOne
	@JoinColumn(name = "cinemaid")
	Cinema cinema;

	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	List<Showtimes> showtimes;

	public Employee() {
		super();
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Showtimes> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<Showtimes> showtimes) {
		this.showtimes = showtimes;
	}
	
	

}
