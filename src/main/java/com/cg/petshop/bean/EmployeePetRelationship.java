package com.cg.petshop.bean;

import com.cg.petshop.compositekeys.EmployeePetRelationId;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_pet_relationship")
public class EmployeePetRelationship {
	
	@EmbeddedId  
	//to create composite key
	
	private EmployeePetRelationId id;
	
	@ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id",insertable = false, updatable = false)
    private Pets pet;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id",insertable = false, updatable = false)
    private Employees employee;

	public EmployeePetRelationId getId() {
		return id;
	}

	public Pets getPet() {
		return pet;
	}

	public Employees getEmployee() {
		return employee;
	}
    
    
    
    
}