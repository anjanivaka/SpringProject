package com.cg.petshop.exceptions.AddressAndSuppliers;

public class AddressNotFoundException extends RuntimeException {
	
		public AddressNotFoundException(String message) {
			super(message);
		}
		public AddressNotFoundException(String message,Throwable e) {
			super(message,e);
		}
		public AddressNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
			super( message,e,enablesupression,enablestacktrace);
		}
	 
	}

