package com.cg.petshop.exceptions.foodcategoryaddress;

public class PetFoodBrandNotFoundException extends RuntimeException{

	public PetFoodBrandNotFoundException(String message) {
		super(message);
	}
	public PetFoodBrandNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public PetFoodBrandNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
