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
	EmployeeRepository repository;

	public List<Employee> findAll(Integer st) {
		return repository.findEmployeeByStatus(st);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public Employee add(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> addAll(List<Employee> list) {
		List<Employee> res = new ArrayList<>();
		for (Employee employee : list) {
			res.add(add(employee));
		}
		return res;
	}

	public Optional<Employee> findById(Integer id) {
		return repository.findEmployeeById(id);
	}
	

	public List<Employee> findByName(String name) {
		return repository.findByName(name);
	}

	public Employee save(Employee employee){
        return repository.saveAndFlush(employee);
    }

	}

