package com.Entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "roleid", unique = true, nullable = false)
	private Integer roleId;

	@Column(name = "name", unique = true)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "role")
	private List<EmpRole> empRole;

	public Role() {
		super();
	}

	public Role(Integer roleId, String name, List<EmpRole> empRole) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.empRole = empRole;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmpRole> getEmpRole() {
		return empRole;
	}

	public void setEmpRole(List<EmpRole> empRole) {
		this.empRole = empRole;
	}

}
