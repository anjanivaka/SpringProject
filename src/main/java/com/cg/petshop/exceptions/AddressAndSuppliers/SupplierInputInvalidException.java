package com.cg.petshop.exceptions.AddressAndSuppliers;

public class SupplierInputInvalidException extends RuntimeException {
	public SupplierInputInvalidException(String message) {
		super(message);
	}
	public SupplierInputInvalidException(String message,Throwable e) {
		super(message,e);
	}
	public SupplierInputInvalidException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
