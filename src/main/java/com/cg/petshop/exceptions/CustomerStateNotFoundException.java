package com.cg.petshop.exceptions;

public class CustomerStateNotFoundException extends Throwable {
	public CustomerStateNotFoundException(String message) {
		super(message);
	}
	public CustomerStateNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public CustomerStateNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
