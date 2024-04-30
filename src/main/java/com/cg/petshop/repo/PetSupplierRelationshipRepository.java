package com.cg.petshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.petshop.bean.PetSupplierRelationship;
import com.cg.petshop.compositekeys.PetSupplierRelationshipId;

public interface PetSupplierRelationshipRepository extends JpaRepository<PetSupplierRelationship, PetSupplierRelationshipId>{
	@Query("SELECT psr.pet,psr.supplier FROM PetSupplierRelationship psr WHERE psr.id.pet_id = :pet_id")
	List<Object[]> findSupplierByPetId(int pet_id);
}
