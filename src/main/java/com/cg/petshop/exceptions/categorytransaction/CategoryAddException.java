package com.cg.petshop.exceptions.categorytransaction;

public class CategoryAddException extends RuntimeException {
	
	public CategoryAddException(String message){
			super(message);
		}
	
		public CategoryAddException(String message,Throwable e) {
			super(message,e);
		}
		public CategoryAddException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
			super( message,e,enablesupression,enablestacktrace);
		}

}


