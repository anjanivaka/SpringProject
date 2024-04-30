package com.cg.petshop.exceptions.categorytransaction;

public class TransactionCannotbeAddedException extends RuntimeException {
	
	public TransactionCannotbeAddedException(String message){
		super(message);
	}

	public TransactionCannotbeAddedException(String message,Throwable e) {
		super(message,e);
	}
	public TransactionCannotbeAddedException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
}

 

