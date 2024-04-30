package com.cg.petshop.exceptions;

public class EmployeeCannotBeAddedException extends Throwable{
	public EmployeeCannotBeAddedException(String message) {
		super(message);
	}
	public EmployeeCannotBeAddedException(String message,Throwable e) {
		super(message,e);
	}
	public EmployeeCannotBeAddedException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
