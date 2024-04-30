package com.cg.petshop.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cg.petshop.service.PetCategoriesService;
import com.cg.petshop.bean.PetCategories;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;


@RestController
public class PetCategoriesController {
	
	

		    @Autowired
		    PetCategoriesService PetCategories_service;
			
		    
			@GetMapping("/api/v1/categories")
			public List<PetCategories> retreiveAll(){
				return PetCategories_service.retreiveAllCategories();
			}

			
			@GetMapping("/api/v1/categories/{category_id}")
			public PetCategories retrieveById(@PathVariable("category_id") int categoryId) {
				return PetCategories_service.retreivePetCategoriesId(categoryId);
			}
			

//			@GetMapping("/api/v1/categories/name/{category_name}")
//			public PetCategories retrieveById(@PathVariable("category_name") String name ) {
//				return PetCategories_service.retreivePetCategories(name);
//				
//			}
			//post    /api/v1/categories/add

			
			//post    

			
			@PostMapping("/api/v1/categories/add")
		    public PetCategories addCategory(@RequestBody PetCategories petCate) throws MismatchDataTypeException {
		        return PetCategories_service.addCategory(petCate);
		    }

			
			
			 
			 //update or put
			 @PutMapping("/api/v1/categories/update/{category_id}")
			 public SuccessResponse updateCategoryName(@PathVariable("category_id") int categoryId, @RequestBody PetCategories updatedCategory) throws MismatchDataTypeException {
			     return PetCategories_service.updateCategoryName(categoryId, updatedCategory.getName());
			 }

}


			
			
			
			
			
			

