package com.cg.petshop.exceptions;

public class CustomerIdNotFoundException extends Throwable{
	public CustomerIdNotFoundException(String message) {
		super(message);
	}
	public CustomerIdNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public CustomerIdNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
