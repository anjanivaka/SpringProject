package com.cg.petshop.exceptions;

public class EmployeeIdNotFoundException extends Throwable{
	public EmployeeIdNotFoundException(String message) {
		super(message);
	}
	public EmployeeIdNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public EmployeeIdNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
