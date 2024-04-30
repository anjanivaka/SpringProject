package com.cg.petshop.exceptions.pets;

public class NoSupplierFoundException extends Throwable{
	public NoSupplierFoundException(String message) {
		super(message);
	}
	public NoSupplierFoundException(String message,Throwable e) {
		super(message,e);
	}
	public NoSupplierFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
}
