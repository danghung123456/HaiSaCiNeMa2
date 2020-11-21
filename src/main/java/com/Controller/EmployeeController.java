package com.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.Entity.Movie;
import com.Entity.User;
import com.Services.EmployeeService;
import com.Services.UserService;
import com.Constant.*;
import com.DTO.Base.ResponseEntity;

@RestController
@RequestMapping(value = "employee")

public class EmployeeController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.body(employeeService.getAll());
	}

	@GetMapping("/{status}")
	public ResponseEntity<Object> getEmployeePresent(@PathVariable("status") Integer status) {
		// tìm danh sách employee theo status : 1 : đang hoạt động 2: ngưng hoạt động
		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		List<Employee> listEmployee = employeeService.getAllByStatus(st);
		if (listEmployee.isEmpty()) {
			return ResponseEntity.body(Constant.NOT_FOUND);
		} else {
			return ResponseEntity.body(listEmployee);
		}
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		if (employeeDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
//	            Make sure id is NULL to insert Entity
			User user = new User();
			user.setEmail(employeeDTO.getEmail());
			String password = passwordEncoder.encode(employeeDTO.getPassword());
			user.setPassword(password);
			user = userService.add(user);
			employeeDTO.setEmployeeId(null);
			Employee employee = employeeService.convertToEmployee(employeeDTO);
			employee.setUser(user);
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
				User user = checkEmployee.orElse(null).getUser();
				String password = passwordEncoder.encode(employeeDTO.getPassword());
				user.setPassword(password);
				user = userService.update(user);
				Employee employee = employeeService.convertToEmployee(employeeDTO);
				employee.setUser(user);
				employee = employeeService.save(employee);
				return ResponseEntity.body(employee);
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
				employee.setStatus(3);
				return ResponseEntity.body(employeeService.save(employee));
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@GetMapping("/findbyid")
	public ResponseEntity<Object> findById(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Employee> optionalEmployee = employeeService.findById(id);
			if (optionalEmployee.isPresent()) {
				Employee employee = optionalEmployee.orElse(null);
				return ResponseEntity.body(employee);
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@GetMapping("/findbyname")
	public ResponseEntity<Object> findByName(String name) {
		if (name == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			List<Employee> listEmployee = employeeService.findByName(name);
			if (listEmployee.isEmpty()) {
				return ResponseEntity.body(Constant.NOT_FOUND);
			} else {
				return ResponseEntity.body(listEmployee);
			}
		}
	}

//	@GetMapping("/findbyrole/{role}")
//	public ResponseEntity<Object> findByRole(@PathVariable("role") Integer role) {
//		// role 1 :quản lý ,role 0 : nhân viên;
//		if (role == null) {
//			return ResponseEntity.body(Constant.BAD_REQUEST);
//		} else {
//			List<Employee> listEmployee = employeeService.findByRole(role);
//			if (listEmployee.isEmpty()) {
//				return ResponseEntity.body(Constant.NOT_FOUND);
//			} else {
//				return ResponseEntity.body(listEmployee);
//			}
//		}
//	}
}
