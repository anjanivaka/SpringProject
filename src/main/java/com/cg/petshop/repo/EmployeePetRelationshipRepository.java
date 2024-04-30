package com.cg.petshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.petshop.bean.EmployeePetRelationship;
import com.cg.petshop.compositekeys.EmployeePetRelationId;

public interface EmployeePetRelationshipRepository extends JpaRepository<EmployeePetRelationship, EmployeePetRelationId>{

}
