package com.cg.petshop.exceptions;

public class CustomerCityNotFoundException extends Throwable{
	public CustomerCityNotFoundException(String message) {
		super(message);
	}
	public CustomerCityNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public CustomerCityNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
