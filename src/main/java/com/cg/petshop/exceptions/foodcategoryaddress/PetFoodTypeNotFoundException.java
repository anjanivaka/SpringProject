package com.cg.petshop.exceptions.foodcategoryaddress;

public class PetFoodTypeNotFoundException extends RuntimeException{

	public PetFoodTypeNotFoundException(String message) {
		super(message);
	}
	public PetFoodTypeNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public PetFoodTypeNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

	
}
