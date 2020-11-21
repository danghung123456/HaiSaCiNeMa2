package com.Services;

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

	List<Employee> findByName(String name);
	
//	List<Employee> findByRole(Integer role);

	Employee save(Employee employee);
	
	
}
