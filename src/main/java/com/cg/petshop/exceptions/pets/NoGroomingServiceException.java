package com.cg.petshop.exceptions.pets;

public class NoGroomingServiceException extends Throwable{
	public NoGroomingServiceException(String message) {
		super(message);
	}
	public NoGroomingServiceException(String message,Throwable e) {
		super(message,e);
	}
	public NoGroomingServiceException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
}
