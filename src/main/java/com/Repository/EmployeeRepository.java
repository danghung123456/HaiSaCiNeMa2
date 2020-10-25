package com.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value = "SELECT * FROM Employee e WHERE e.employeeName LIKE %?% AND e.status = 1", nativeQuery = true)
	List<Employee> findByName(String name);
}
