package com.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DTO.EmployeeDTO;
import com.Entity.Employee;
import com.Services.EmployeeService;
import com.Constant.*;
import com.DTO.Base.ResponseEntiy;

@RestController
@RequestMapping(value = "employee")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> index(Integer status) {
		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		return employeeService.findAll(st);

	}

	@PostMapping(value = "/add")
	public ResponseEntiy<Object> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		 if (employeeDTO.isNull(false)) {
	            return ResponseEntiy.body(Constant.BAD_REQUEST);
	        } else {
//	            Make sure id is NULL to insert Entity
	            employeeDTO.setEmployeeId(null);
	            Employee employee = employeeDTO.convertToEmployee();
	            return ResponseEntiy.body(employeeService.add(employee));
	        }
	}

	
	@PutMapping(value = "/update")
	public ResponseEntiy<Object> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		if (employeeDTO.isNull(true)) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Employee> checkEmployee = employeeService.findById(employeeDTO.getEmployeeId());
            if (checkEmployee.isPresent()) {
                Employee employee = employeeDTO.convertToEmployee();
                return ResponseEntiy.body(employeeService.save(employee));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@PutMapping(value = "/delete")
	public ResponseEntiy<Object> deleteEmployee(@RequestBody EmployeeDTO employeeDTO) {
		if (employeeDTO.getEmployeeId() == null) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Employee> checkEmployee = employeeService.findById(employeeDTO.getEmployeeId());
            if (checkEmployee.isPresent()) {
            	Employee employee = employeeDTO.convertToEmployee();
            	employee.setStatus(0);
                return ResponseEntiy.body(employeeService.save(employee));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@GetMapping("/findbyid")
	public ResponseEntiy<Object> findById(Integer id) {
		return  ResponseEntiy.body(employeeService.findById(id));
	}
	
	@GetMapping("/findbyname")
	public ResponseEntiy<Object> findByName(String name) {
		return ResponseEntiy.body(employeeService.findByName(name));
	}

}
