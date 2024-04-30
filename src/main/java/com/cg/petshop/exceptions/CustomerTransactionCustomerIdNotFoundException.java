package com.cg.petshop.exceptions;

public class CustomerTransactionCustomerIdNotFoundException extends Throwable{
	public CustomerTransactionCustomerIdNotFoundException(String message) {
		super(message);
	}
	public CustomerTransactionCustomerIdNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public CustomerTransactionCustomerIdNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

}
