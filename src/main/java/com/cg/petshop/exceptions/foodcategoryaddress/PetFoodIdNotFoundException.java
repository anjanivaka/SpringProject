package com.cg.petshop.exceptions.foodcategoryaddress;

public class PetFoodIdNotFoundException extends RuntimeException{

	public PetFoodIdNotFoundException(String message) {
		super(message);
	}
	public PetFoodIdNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public PetFoodIdNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
}
