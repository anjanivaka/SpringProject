package com.cg.petshop.exceptions.pets;

public class NoFoodInfoException extends Throwable{
	public NoFoodInfoException(String message) {
		super(message);
	}
	public NoFoodInfoException(String message,Throwable e) {
		super(message,e);
	}
	public NoFoodInfoException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
}
