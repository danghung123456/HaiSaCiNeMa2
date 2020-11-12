package com.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DTO.EmployeeDTO;
import com.Entity.Employee;
import com.Services.EmployeeService;
import com.Constant.*;
import com.DTO.Base.ResponseEntity;

@RestController
@RequestMapping(value = "employee")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.body(employeeService.getAll());
	}


	@GetMapping("/{status}")
	public ResponseEntity<List<Employee>> getEmployeePresent(@PathVariable("status") Integer status) {
		//tìm danh sách employee theo status : 1 : đang hoạt động 2: ngưng hoạt động
 		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		return ResponseEntity.body(employeeService.getAllByStatus(st));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		 if (employeeDTO.isNull(false)) {
	            return ResponseEntity.body(Constant.BAD_REQUEST);
	        } else {
//	            Make sure id is NULL to insert Entity
	            employeeDTO.setEmployeeId(null);
	            Employee employee = employeeDTO.convertToEmployee();
	            return ResponseEntity.body(employeeService.add(employee));
	        }
	}

	
	@PutMapping(value = "/update")
	public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		if (employeeDTO.isNull(true)) {
            return ResponseEntity.body(Constant.BAD_REQUEST);
        } else {
            Optional<Employee> checkEmployee = employeeService.findById(employeeDTO.getEmployeeId());
            if (checkEmployee.isPresent()) {
                Employee employee = employeeDTO.convertToEmployee();
                return ResponseEntity.body(employeeService.save(employee));
            } else {
                return ResponseEntity.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@PutMapping(value = "/delete")
	public ResponseEntity<Object> deleteEmployee(Integer id) {
		if (id == null) {
            return ResponseEntity.body(Constant.BAD_REQUEST);
        } else {
            Optional<Employee> checkEmployee = employeeService.findById(id);
            if (checkEmployee.isPresent()) {
            	Employee employee = checkEmployee.orElse(null);
            	// status = 1 : đang hoạt động, status = 2 : ngưng hoạt động
            	employee.setStatus(2);
            	employee.setRole(3);
                return ResponseEntity.body(employeeService.save(employee));
            } else {
                return ResponseEntity.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@GetMapping("/findbyid")
	public ResponseEntity<Object> findById(Integer id) {
		return  ResponseEntity.body(employeeService.findById(id));
	}
	
	@GetMapping("/findbyname")
	public ResponseEntity<Object> findByName(String name) {
		return ResponseEntity.body(employeeService.findByName(name));
	}
	@GetMapping("/findbyrole/{role}")
	public ResponseEntity<Object> findByRole(@PathVariable("role") Integer role){
		// role 1 :quản lý ,role 0 : nhân viên;
		return ResponseEntity.body(employeeService.findByRole(role));
	}

}
