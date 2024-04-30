package com.cg.petshop.exceptions.pets;

public class PetIdNotFoundException extends Throwable{
	
	public PetIdNotFoundException(String message) {
		super(message);
	}
	public PetIdNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public PetIdNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
