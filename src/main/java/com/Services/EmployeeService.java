package com.Services;

import com.DTO.EmployeeDTO;
import com.Entity.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
	/**
	 * Find all entity Employee with status entered( present or resign)
	 * 
	 * @return List<Employee>
	 */
	List<Employee> getAllByStatus(Integer st);

	/**
	 * Find all entity Employee
	 * 
	 * @return List<Employee>
	 */
	List<Employee> getAll();

	/**
	 * Delete all entity Employee already exists
	 * 
	 * @return void
	 */
	void deleteAll();

	/**
	 * Saves a entity Employee
	 * 
	 * @return Employee
	 */
	Employee add(Employee employee);

	/**
	 * Saves all entity Employee from list Employee
	 * 
	 * @return List<Employee>
	 */
	List<Employee> addAll(List<Employee> list);

	/**
	 * Search an entity Employee by its id
	 * 
	 * @return the entity with the EmployeeId entered or Optional#empty() if none
	 *         found.
	 */
	Optional<Employee> findById(Integer id);

<<<<<<< HEAD
	/**
	 * Search list Employee with the same name(employeeName) entered
	 * 
	 * @return List<Employee>
	 */
	List<Employee> findByName(String name);
=======
	List<Employee> findByName(String name, Integer status);
>>>>>>> bdcd4ea57cfee0eff01478f49a4a2f4c424c62a7

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity Employee
	 */
	Employee save(Employee employee);

	/**
	 * Convert from EmployeeDTO to entity Employee
	 * 
	 * @return entity Employee
	 */
	Employee convertToEmployee(EmployeeDTO employeeDTO);
}
