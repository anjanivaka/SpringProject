package com.cg.petshop.exceptions.foodcategoryaddress;

public class PetFoodNameNotFoundException extends RuntimeException{

	public PetFoodNameNotFoundException(String message) {
		super(message);
	}
	public PetFoodNameNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public PetFoodNameNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
