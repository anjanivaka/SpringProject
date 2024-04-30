package com.cg.petshop.exceptions;

public class CustomerFirstnameLastnameNotFoundException extends Throwable{
	
	public CustomerFirstnameLastnameNotFoundException(String message) {
		super(message);
	}
	public CustomerFirstnameLastnameNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public CustomerFirstnameLastnameNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}


}
