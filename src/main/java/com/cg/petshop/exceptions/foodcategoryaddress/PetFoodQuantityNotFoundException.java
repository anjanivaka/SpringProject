package com.cg.petshop.exceptions.foodcategoryaddress;

public class PetFoodQuantityNotFoundException extends RuntimeException{

	public PetFoodQuantityNotFoundException(String message) {
		super(message);
	}
	public PetFoodQuantityNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public PetFoodQuantityNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
