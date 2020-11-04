package com.Services;

import com.Entity.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
	
	public List<Employee> getAll(Integer st);
	
    public void deleteAll();

    public Employee add(Employee employee);

    public List<Employee> addAll(List<Employee> list);
    
    public Optional<Employee> findById(Integer id);
    
    public List<Employee> findByName(String name);

    public Employee save(Employee employee);
}
