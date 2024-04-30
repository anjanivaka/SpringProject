package com.cg.petshop.exceptions.AddressAndSuppliers;

public class SupplierNotFoundException extends RuntimeException {
	public SupplierNotFoundException(String message) {
		super(message);
	}
	public SupplierNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public SupplierNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
 

}
