package com.cg.petshop.exceptions;

public class CustomerTransactionStatusNotFoundException extends Throwable{
	public CustomerTransactionStatusNotFoundException(String message) {
		super(message);
	}
	public CustomerTransactionStatusNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public CustomerTransactionStatusNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
}
