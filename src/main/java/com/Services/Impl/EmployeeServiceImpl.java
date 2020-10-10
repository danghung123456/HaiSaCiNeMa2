package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.Entity.Employee;

import com.Repository.EmployeeRepository;
import com.Services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeerepository;

	public List<Employee> findAll() {
		return employeerepository.findAll();
	}

	public void deleteAll() {
		employeerepository.deleteAll();
	}

	public Employee add(Employee employee) {
		return employeerepository.save(employee);
	}

	public List<Employee> addAll(List<Employee> list) {
		List<Employee> res = new ArrayList<>();
		for (Employee employee : list) {
			res.add(add(employee));
		}
		return res;
	}

	public Optional<Employee> findById(Integer id) {
		return employeerepository.findById(id);
	}

	public List<Employee> findByName(String name) {
		return employeerepository.findByName(name);
	}

	public Employee save(Employee employee){
        return employeerepository.saveAndFlush(employee);
    }

	}

