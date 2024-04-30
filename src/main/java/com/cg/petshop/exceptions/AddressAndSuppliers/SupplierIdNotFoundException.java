package com.cg.petshop.exceptions.AddressAndSuppliers;

public class SupplierIdNotFoundException extends RuntimeException{
	public SupplierIdNotFoundException(String message) {
		super(message);
	}
	public SupplierIdNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public SupplierIdNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
 

}
