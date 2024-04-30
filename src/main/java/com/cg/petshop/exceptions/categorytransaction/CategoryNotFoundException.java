package com.cg.petshop.exceptions.categorytransaction;

public class CategoryNotFoundException extends RuntimeException {
	
	public CategoryNotFoundException(String message){
			super(message);
		}
	
		public CategoryNotFoundException(String message,Throwable e) {
			super(message,e);
		}
		public CategoryNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
			super( message,e,enablesupression,enablestacktrace);
		}

	

}
