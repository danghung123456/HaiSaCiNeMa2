package com.Entity;
// default package
// Generated Oct 11, 2020, 8:25:38 PM by Hibernate Tools 5.1.10.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cinema generated by hbm2java
 */
@Entity
@Table(name = "Cinema")
public class Cinema  {

	private Integer cinemaId;
	private String name;
	private String address;
	private Set<Room> rooms = new HashSet<Room>(0);
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Cinema() {
	}

	public Cinema(String name, String address, Set<Room> rooms, Set<Employee> employees) {
		this.name = name;
		this.address = address;
		this.rooms = rooms;
		this.employees = employees;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cinemaid", unique = true, nullable = false)
	public Integer getCinemaId() {
		return this.cinemaId;
	}

	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}

	@Column(name = "name")
	public Serializable getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address")
	public Serializable getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cinema")
	public Set<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cinema")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
