package com.Services;

import com.DTO.EmployeeDTO;
import com.Entity.Cinema;
import com.Entity.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

	List<Employee> getAllByStatus(Integer st);
	
	List<Employee> getAll();

	void deleteAll();

	Employee add(Employee employee);

	List<Employee> addAll(List<Employee> list);

	Optional<Employee> findById(Integer id);

	List<Employee> findByName(String name, Integer status);

	Employee save(Employee employee);
	
	Employee convertToEmployee(EmployeeDTO employeeDTO);
}
