package com.cg.petshop.exceptions.AddressAndSuppliers;

public class SupplierCityNotFoundException extends RuntimeException {
	public SupplierCityNotFoundException(String message) {
		super(message);
	}
	public SupplierCityNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public SupplierCityNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
