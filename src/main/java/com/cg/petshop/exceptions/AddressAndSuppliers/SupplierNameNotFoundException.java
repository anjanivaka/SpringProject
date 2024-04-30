package com.cg.petshop.exceptions.AddressAndSuppliers;

public class SupplierNameNotFoundException extends Exception {
	public SupplierNameNotFoundException(String message) {
		super(message);
	}
	public SupplierNameNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public SupplierNameNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
 

}
