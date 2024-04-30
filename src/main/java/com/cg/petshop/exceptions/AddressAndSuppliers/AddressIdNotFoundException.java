package com.cg.petshop.exceptions.AddressAndSuppliers;

public class AddressIdNotFoundException extends RuntimeException{
	public AddressIdNotFoundException(String message) {
		super(message);
	}
	public AddressIdNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public AddressIdNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
