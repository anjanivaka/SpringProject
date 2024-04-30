package com.cg.petshop.exceptions.pets;

public class NoPetsFoundException extends Throwable{
	public NoPetsFoundException(String message) {
		super(message);
	}
	public NoPetsFoundException(String message,Throwable e) {
		super(message,e);
	}
	public NoPetsFoundException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
}
