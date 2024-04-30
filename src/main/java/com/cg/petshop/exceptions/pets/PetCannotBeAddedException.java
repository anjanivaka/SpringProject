package com.cg.petshop.exceptions.pets;

public class PetCannotBeAddedException extends Throwable{
	public PetCannotBeAddedException(String message) {
		super(message);
	}
	public PetCannotBeAddedException(String message,Throwable e) {
		super(message,e);
	}
	public PetCannotBeAddedException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
}
