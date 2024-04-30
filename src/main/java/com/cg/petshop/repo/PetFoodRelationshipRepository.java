package com.cg.petshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.petshop.bean.PetFoodRelationship;
import com.cg.petshop.compositekeys.PetFoodRelationshipId;

public interface PetFoodRelationshipRepository extends JpaRepository<PetFoodRelationship, PetFoodRelationshipId>{
	@Query("SELECT pfr.pet,pfr.food FROM PetFoodRelationship pfr WHERE pfr.id.petId = :pet_id")
	List<Object[]> findFoodDetailsByPetId(int pet_id);
}
 