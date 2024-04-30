package com.cg.petshop.serviceinterface;

import java.util.List;

import com.cg.petshop.bean.PetFood;

public interface PetFoodServiceInterface {

	public List<PetFood> retreiveAllPetFood();
	public PetFood getFoodById(int foodId);
	public List<PetFood> getPetFoodByType(String type);
	public List<PetFood> getPetFoodByName(String name);
	public List<PetFood> getPetFoodByBrand(String brand);
	public PetFood addFood(PetFood petfood);
	public PetFood updateFood(int food_id, PetFood updatedPetFoods);
	public PetFood updateQuantity(int food_id, PetFood food);
}
