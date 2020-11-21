package com.Entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "emprole", uniqueConstraints = { @UniqueConstraint(columnNames = { "roleid", "employeeid" }) })
public class EmpRole {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "emproleid", unique = true, nullable = false)
	private Integer empRoleId;

	@ManyToOne
	@JoinColumn(name = "roleid")
	private Role role;

	@ManyToOne
	@JoinColumn(name = "employeeid")
	private Employee employee;

	public EmpRole() {
		super();
	}

	public EmpRole(Integer empRoleId, Role role, Employee employee) {
		super();
		this.empRoleId = empRoleId;
		this.role = role;
		this.employee = employee;
	}

	public Integer getEmpRoleId() {
		return empRoleId;
	}

	public void setEmpRoleId(Integer empRoleId) {
		this.empRoleId = empRoleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmpRole [empRoleId=" + empRoleId + ", role=" + role + ", employee=" + employee + "]";
	}

}
