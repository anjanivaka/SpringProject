package com.cg.petshop.serviceinterface;

import java.util.List;

import com.cg.petshop.bean.Pets;
import com.cg.petshop.bean.Transactions;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.pets.*;


public interface PetServiceInterface {
	List<Pets> retreiveAllPets() throws NoPetsFoundException;
	
	Pets retreiveById(int id) throws PetIdNotFoundException;
	
	List<Pets> getPetsByCategory(String category) throws PetCategoryNotFoundException;
	
	List<Object> getPetsBygrooming(int pet_id) throws NoGroomingServiceException, PetIdNotFoundException;
	
	List<Object> getPetsByvaccination(int pet_id) throws NoVaccinationException, PetIdNotFoundException;
	
	List<Object[]> getPetsByPetFood(int pet_id) throws NoFoodInfoException, PetIdNotFoundException;
	
	List<Object[]> getSupplierByPetId(int pet_id) throws NoSupplierFoundException, PetIdNotFoundException;
	
	SuccessResponse addPets(Pets pet) throws PetCannotBeAddedException, MismatchDataTypeException, PetAlreadyExistsException;
	
	SuccessResponse updatePets(Pets pet,int id);
	
	Transactions getTransactionByPetId(int pet_id) throws NoTransactionFoundException, PetIdNotFoundException;
}
