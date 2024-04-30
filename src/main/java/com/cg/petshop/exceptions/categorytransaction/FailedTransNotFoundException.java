package com.cg.petshop.exceptions.categorytransaction;

public class FailedTransNotFoundException extends Throwable {
	
	public FailedTransNotFoundException(String message){
		super(message);
	}

	public FailedTransNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public FailedTransNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
 

}
