package com.cg.petshop.exceptions.categorytransaction;

public class TransactionsNotFoundException extends RuntimeException {
	
	public TransactionsNotFoundException(String message){
		super(message);
	}

	public TransactionsNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public TransactionsNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}


}
