package com.cg.petshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.petshop.bean.PetFood;

public interface PetFoodRepository extends JpaRepository<PetFood, Integer>{

	List<PetFood> findByType(String type);

	List<PetFood> findByName(String name);

	List<PetFood> findByBrand(String brand);
}
