package com.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT e FROM Employee e WHERE e.employeeId = :id AND e.status = 1")
	Optional<Employee> findEmployeeById(Integer id);

	@Query("FROM Employee e WHERE e.status = :status")
	List<Employee> findEmployeeByStatus(Integer status);

<<<<<<< HEAD
	@Query(value = "SELECT e FROM Employee e WHERE e.name LIKE %:name% AND e.status = 1")
	List<Employee> findByName(String name);
=======
	@Query(value = "SELECT e FROM Employee e WHERE e.name LIKE %:name% AND e.status = :status")
	List<Employee> findByName(String name, Integer status);
>>>>>>> bdcd4ea57cfee0eff01478f49a4a2f4c424c62a7

}
