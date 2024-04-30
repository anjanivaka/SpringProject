package com.cg.petshop.exceptions.foodcategoryaddress;

public class NoPetFoodFoundException extends RuntimeException{

	public NoPetFoodFoundException(String message) {
		super(message);
	}
	public NoPetFoodFoundException(String message,Throwable e) {
		super(message,e);
	}
	public NoPetFoodFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}


}
