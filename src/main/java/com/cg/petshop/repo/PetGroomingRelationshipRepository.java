package com.cg.petshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.petshop.bean.PetGroomingRelationship;
import com.cg.petshop.bean.Pets;
import com.cg.petshop.compositekeys.PetGroomingRelationshipId;

@Repository
public interface PetGroomingRelationshipRepository extends JpaRepository<PetGroomingRelationship, PetGroomingRelationshipId>{
//	@Query("SELECT pgr.pet,pgr.groomingservices FROM PetGroomingRelationship pgr WHERE pgr.id.pet_id = :pet_id")
//	List<Object[]> findGroomingServicesByPetId(int pet_id);

	

		
}
