package com.cg.petshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.petshop.bean.PetVaccinationRelationship;
import com.cg.petshop.compositekeys.PetVaccinationRelationId;

public interface PetVaccinationRelationshipRepository extends 
	JpaRepository<PetVaccinationRelationship, PetVaccinationRelationId>{
	
	@Query("SELECT pvr.pet,pvr.vaccination FROM PetVaccinationRelationship pvr WHERE pvr.id.pet_id = :pet_id")
	List<Object[]> findVaccinationsByPetId(int pet_id);

}
