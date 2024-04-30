package com.cg.petshop.exceptions.foodcategoryaddress;

public class PetFoodNotFoundException extends RuntimeException{

	public PetFoodNotFoundException(String message) {
		super(message);
	}
	public PetFoodNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public PetFoodNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

	
}
