package com.cg.petshop.exceptions;

public class EmployeePositionNotFoundException extends RuntimeException{
	public EmployeePositionNotFoundException(String message) {
		super(message);
	}
	public EmployeePositionNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public EmployeePositionNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
