package com.cg.petshop.exceptions.AddressAndSuppliers;

public class AddressInputInvalidException extends RuntimeException{
	public AddressInputInvalidException(String message) {
		super(message);
	}
	public AddressInputInvalidException(String message,Throwable e) {
		super(message,e);
	}
	public AddressInputInvalidException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
 
}
