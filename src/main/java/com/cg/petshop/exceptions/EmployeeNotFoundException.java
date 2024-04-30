package com.cg.petshop.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(String message) {
		super(message);
	}
	public EmployeeNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public EmployeeNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
