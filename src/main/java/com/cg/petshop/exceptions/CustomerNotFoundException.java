package com.cg.petshop.exceptions;

public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException(String message) {
		super(message);
	}
	public CustomerNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public CustomerNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}


}
