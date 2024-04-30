package com.cg.petshop.serviceinterface;

import java.util.List;

import com.cg.petshop.bean.PetCategories;

public interface PetCategoriesServiceInterface {
	
	public List<PetCategories> retreiveAllCategories();
	public PetCategories retreivePetCategoriesId(int categoryId);
	public PetCategories addCategory(PetCategories petCate);
	public PetCategories updateCategoryName(int categoryId, String categoryName);

}
