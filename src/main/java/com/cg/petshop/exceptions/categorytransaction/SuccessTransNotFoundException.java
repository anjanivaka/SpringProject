package com.cg.petshop.exceptions.categorytransaction;

public class SuccessTransNotFoundException extends Throwable {
	
	public SuccessTransNotFoundException(String message){
		super(message);
	}

	public SuccessTransNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	public SuccessTransNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}

 

}
