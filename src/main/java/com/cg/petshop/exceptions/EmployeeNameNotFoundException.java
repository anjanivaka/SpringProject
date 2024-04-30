package com.cg.petshop.exceptions;

public class EmployeeNameNotFoundException extends RuntimeException{
	public EmployeeNameNotFoundException(String message) {
		super(message);
	}
	public EmployeeNameNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public EmployeeNameNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}

