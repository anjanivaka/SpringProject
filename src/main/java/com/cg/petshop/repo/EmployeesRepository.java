package com.cg.petshop.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.petshop.bean.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer>{
	//Employees getAllEmployees();
	Employees findById(int employee_id);

	Employees findByFirstName(String firstName);

	Optional<Employees> findByLastName(String lastName);

	Employees findByFirstNameAndLastName(String firstName, String lastName);

	List<Employees> findByPosition(String position);

}
