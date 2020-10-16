package com.Entity;
// default package
// Generated Oct 13, 2020, 8:28:21 PM by Hibernate Tools 5.1.10.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Cinema generated by hbm2java
 */
@Entity
@Table(name = "cinema")
public class Cinema  {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cinemaid", unique = true, nullable = false)
	Integer cinemaid;

	@Column(name = "name")
	String name;

	@Column(name = "address")
	String  address;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cinema")
	List<Room> room;

	@JsonIgnore
	@OneToMany(mappedBy = "cinema")
	List<Employee> employee;

	public Cinema() {
		super();
	}

	public Integer getCinemaid() {
		return cinemaid;
	}

	public void setCinemaid(Integer cinemaid) {
		this.cinemaid = cinemaid;
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

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}
