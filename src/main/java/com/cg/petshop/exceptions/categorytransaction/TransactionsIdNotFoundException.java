package com.cg.petshop.exceptions.categorytransaction;

public class TransactionsIdNotFoundException extends RuntimeException {
	
	public TransactionsIdNotFoundException(String message){
		super(message);
	}

	public TransactionsIdNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public TransactionsIdNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

 

}
