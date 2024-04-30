package com.cg.petshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.cg.petshop.Service.EmployeeService;
import com.cg.petshop.bean.Employees;
import com.cg.petshop.exceptions.EmployeeCannotBeAddedException;
import com.cg.petshop.exceptions.EmployeeIdNotFoundException;
import com.cg.petshop.exceptions.EmployeeNotFoundException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService emp_service;
	
	@GetMapping
	public List<Employees> getEmployeesData() throws EmployeeNotFoundException{
		return emp_service.getAllEmployees();

	}
	

	@GetMapping("/{employee_id}")
	public Employees getEmpById(@PathVariable int employee_id) throws EmployeeIdNotFoundException{
		return emp_service.getEmployeesById(employee_id);

	}
	
	@GetMapping("/firstname/{firstName}")
	public Employees getEmpByFirstName(@PathVariable String firstName){
		return emp_service.getEmployeesByFirstName(firstName);

	}
	
	@GetMapping("/lastname/{lastName}")
	public Optional<Employees> getEmpByLastName(@PathVariable String lastName){
		return emp_service.getEmployeesByLastName(lastName);

	}
	
	@GetMapping("/name/{firstName}/{lastName}")
	public Employees getEmpByName(@PathVariable String firstName,@PathVariable String lastName){
		return emp_service.getEmployeesByName(firstName,lastName);

	}
	
	@GetMapping("/position/{position}")
	public List<Employees> getEmpByPosition(@PathVariable String position){
		return emp_service.getEmployeesByPosition(position);

	}
	

	
	@PostMapping("/add")
	public SuccessResponse addEmp(@RequestBody Employees employee) throws EmployeeCannotBeAddedException {
		//Employees emp= emp_service.addEmployee(employee);
		return emp_service.addEmployee(employee);
	}
	
	@PutMapping("/update/{employee_id}")
	public SuccessResponse updateEmp(@PathVariable int employee_id,@RequestBody Employees employee) throws EmployeeIdNotFoundException {
		return emp_service.updateEmployee(employee_id,employee);
	}
	
	
	

}
