package com.cg.petshop.repo;


import java.util.List; 
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.petshop.bean.PetCategories;

import jakarta.transaction.Transactional;

public interface PetCatogeriesRepository extends JpaRepository<PetCategories, Integer>{
	
	 
    @Transactional
    @Modifying
    @Query("UPDATE PetCategories p SET p.name = :categoryName WHERE p.id = :categoryId")
    void updateCategoryNameById(int categoryId, String categoryName);

   List<PetCategories> findByName(String name);
//
//
//Optional<PetCategories> findByName(String name);

	



}
