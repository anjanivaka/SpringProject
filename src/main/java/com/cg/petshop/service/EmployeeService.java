package com.cg.petshop.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//import com.cg.petshop.Service.EmployeeService;
import com.cg.petshop.bean.Employees;
import com.cg.petshop.exceptions.EmployeeCannotBeAddedException;
import com.cg.petshop.exceptions.EmployeeIdNotFoundException;
import com.cg.petshop.exceptions.EmployeeNameNotFoundException;
import com.cg.petshop.exceptions.EmployeeNotFoundException;
import com.cg.petshop.exceptions.EmployeePositionNotFoundException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.repo.EmployeesRepository;
import com.cg.petshop.serviceinterface.EmployeeServiceInterface;
@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	private EmployeesRepository employeerepos;
	public EmployeeService(EmployeesRepository emprepos) {
		this.employeerepos = emprepos;
	}
	
	public List<Employees> getAllEmployees() throws EmployeeNotFoundException{
		List<Employees> emp=employeerepos.findAll();
		try {
		if(emp.isEmpty()) {
			throw new EmployeeNotFoundException("Validation Failed");
		}
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}
	
	public Employees getEmployeesById(int employee_id) throws EmployeeIdNotFoundException {
//		try {
//			Integer.parseInt(String.valueOf(employee_id));
//		}
//		catch(NumberFormatException e){
//			throw new EmployeeIdNotFoundException("Validation Failed");
//		}
		try {
			Employees emp=employeerepos.findById(employee_id);
			if(emp==null) {
				throw new EmployeeIdNotFoundException("Validation Failed:Id not found");
			}
			
			return emp;
		}
		catch(NumberFormatException e) {
			throw new EmployeeIdNotFoundException("Validation Failed:Id not found");
		}
		
	}

	public Employees getEmployeesByFirstName(String firstName) {
		// TODO Auto-generated method stub
		Employees emp=employeerepos.findByFirstName(firstName);
		if(emp==null) {
			throw new EmployeeNameNotFoundException("Validation Failed");
		}
		
		return emp;
	}

	public Optional<Employees> getEmployeesByLastName(String lastName) {
		// TODO Auto-generated method stub
		return employeerepos.findByLastName(lastName);
	}

	public Employees getEmployeesByName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		Employees emp=employeerepos.findByFirstNameAndLastName(firstName,lastName);
		if(emp==null) {
			throw new EmployeeNameNotFoundException("Validation Failed:Name not found");
		}
		
		return emp;
	}

	public List<Employees> getEmployeesByPosition(String position) {
		// TODO Auto-generated method stub
		List<Employees> emp=employeerepos.findByPosition(position);
		if(emp==null) {
			throw new EmployeePositionNotFoundException("Validation Failed:Position not found");
		}
		return emp;
	}

	public SuccessResponse addEmployee(Employees emp) throws EmployeeCannotBeAddedException {
		try {
			Employees e=employeerepos.save(emp);
			SuccessResponse s = new SuccessResponse();
			s.setMessage("Data updated\n"+emp);
			s.setStatus("Success");
			s.setTimestamp(LocalDate.now());
			return s;
		}
		catch(Exception e) {
			throw new EmployeeCannotBeAddedException("Validation failed:Employee cannot be added"+e.getMessage());
		}
	}

	public SuccessResponse updateEmployee(int employee_id,Employees employee) throws EmployeeIdNotFoundException {
		// TODO Auto-generated method stub
		Employees emp=employeerepos.findById(employee_id);
		if(emp==null) {
			throw new EmployeeIdNotFoundException("Validation Failed:Id not found");
		}
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setPhoneNumber(employee.getPhoneNumber());
		emp.setPosition(employee.getPosition());
		emp.setEmail(employee.getEmail());
		emp.setHireDate(employee.getHireDate());
		emp.setAddress(employee.getAddress());
		
		SuccessResponse s = new SuccessResponse();
		s.setMessage("Data updated\n"+emp);
		s.setStatus("Success");
		s.setTimestamp(LocalDate.now());
	
		return s;
	}
	
	

}

