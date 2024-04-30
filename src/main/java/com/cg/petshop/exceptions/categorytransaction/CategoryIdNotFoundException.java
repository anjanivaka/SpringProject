package com.cg.petshop.exceptions.categorytransaction;

public class CategoryIdNotFoundException extends RuntimeException {
	
	public CategoryIdNotFoundException(String message){
			super(message);
		}
	
		public CategoryIdNotFoundException(String message,Throwable e) {
			super(message,e);
		}
		public CategoryIdNotFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
			super( message,e,enablesupression,enablestacktrace);
		}

	}


