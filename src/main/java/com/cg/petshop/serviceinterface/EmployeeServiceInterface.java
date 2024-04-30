package com.cg.petshop.serviceinterface;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.petshop.bean.Employees;
import com.cg.petshop.exceptions.EmployeeCannotBeAddedException;
import com.cg.petshop.exceptions.EmployeeIdNotFoundException;
import com.cg.petshop.exceptions.EmployeeNotFoundException;
import com.cg.petshop.exceptions.SuccessResponse;

public interface EmployeeServiceInterface {
	public Employees getEmployeesByName(String firstName, String lastName);
	public List<Employees> getEmployeesByPosition(String position);
	public Employees getEmployeesById(int employee_id) throws EmployeeIdNotFoundException;
	public List<Employees> getAllEmployees() throws EmployeeNotFoundException;
	public SuccessResponse addEmployee(Employees emp) throws EmployeeCannotBeAddedException;
	public SuccessResponse updateEmployee(int employee_id,Employees employee) throws EmployeeIdNotFoundException;
}
