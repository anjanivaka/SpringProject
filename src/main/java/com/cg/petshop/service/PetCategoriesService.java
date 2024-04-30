package com.cg.petshop.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.petshop.bean.PetCategories;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.Validationclass;
import com.cg.petshop.exceptions.categorytransaction.CategoryAddException;
import com.cg.petshop.exceptions.categorytransaction.CategoryIdNotFoundException;
import com.cg.petshop.exceptions.categorytransaction.CategoryNotFoundException;
import com.cg.petshop.repo.PetCatogeriesRepository;

@Service
public class PetCategoriesService {
	
			
		@Autowired
			PetCatogeriesRepository PetCatogeries_repo;
			
		// GET all Categories
			public List<PetCategories> retreiveAllCategories(){
				List<PetCategories> pc = PetCatogeries_repo.findAll();
				if(pc.isEmpty())
					
					throw new CategoryNotFoundException("Validation failed");
			return pc;
		    	}
			//return PetCatogeries_repo.findAll();
			
		
			//Get By Cutsomer Id
			public PetCategories retreivePetCategoriesId(int categoryId) {
				
				try {
					PetCategories pc = PetCatogeries_repo.findById(categoryId).get();
					return pc;
				}
				catch(NoSuchElementException e) {
			    		throw new CategoryIdNotFoundException("Category id not found");
			    	}
			}


			
			

			/*
			//post
			public PetCategories addCategory(PetCategories petCate) {
				
				PetCategories pc = PetCatogeries_repo.save(petCate);
				if(pc.())
				throw new CategoryNotFoundException("Validation failed");
				return pc;
			    	}

				
				//return PetCatogeries_repo.save(petCate);
			}*/
			

			
			//add
			public PetCategories addCategory(PetCategories petCategory) throws MismatchDataTypeException {
			    try {
			        // Check if the category name is a valid string
			        if (!Validationclass.ValidationInt(petCategory.getName())) {
			            throw new MismatchDataTypeException("Category name should be a String");
			        }
			        
			        // Save the category
			        PetCategories addedCategory = PetCatogeries_repo.save(petCategory);
			        
			        if (addedCategory == null) {
			            throw new CategoryAddException("Failed to add category");
			        }
			        
			        return addedCategory;
			    } catch (Exception e) {
			        throw new CategoryAddException("Failed to add category", e);
			    }
			}
			
			
			
			


	
		       

			
//			//update 
//			public SuccessResponse updateCategoryName(int categoryId, String categoryName) throws MismatchDataTypeException {
//			    try {
//			        PetCategories existingCategory = PetCatogeries_repo.findById(categoryId).get();     //orElse(null);
//			        
//			        if (existingCategory != null) {
//			            if (!Validationclass.ValidationInt(existingCategory.getName())) {
//			                throw new MismatchDataTypeException("Category name should be String");
//			            }
//			            existingCategory.setName(categoryName);
//			            PetCatogeries_repo.save(existingCategory);
//			            
//			            SuccessResponse s = new SuccessResponse();
//			            s.setMessage("Data Updated: " + existingCategory);
//			            s.setStatus("Success");
//			            s.setTimestamp(LocalDate.now());
//			            return s;
//			        } else {
//			            throw new CategoryIdNotFoundException("Invalid Category Id");
//			        }
//			    } catch (NoSuchElementException ex) {
//			        throw new CategoryIdNotFoundException("Invalid Category Id");
//			    }
//			}
			
			//update
			public SuccessResponse updateCategoryName(int categoryId, String categoryName) throws MismatchDataTypeException {
			    try {
			        PetCategories existingCategory = PetCatogeries_repo.findById(categoryId).orElse(null);
			        
			        if (existingCategory != null) {
			            if (!Validationclass.ValidationInt(categoryName)) {
			                throw new MismatchDataTypeException("Category name should be a non-empty string");
			            }
			            existingCategory.setName(categoryName);
			            PetCatogeries_repo.save(existingCategory);
			            
			            SuccessResponse s = new SuccessResponse();
			            s.setMessage("Data Updated: " + existingCategory);
			            s.setStatus("Success");
			            s.setTimestamp(LocalDate.now());
			            return s;
			        } else {
			            throw new CategoryIdNotFoundException("Invalid Category Id");
			        }
			    } catch (NoSuchElementException ex) {
			        throw new CategoryIdNotFoundException("Invalid Category Id");
			    }
			}

		}

 




			
			
			
