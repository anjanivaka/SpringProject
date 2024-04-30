package com.cg.petshop.exceptions;

public class MismatchDataTypeException extends Throwable{
	public MismatchDataTypeException(String message) {
		super(message);
	}
	public MismatchDataTypeException(String message,Throwable e) {
		super(message,e);
	}
	public MismatchDataTypeException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
}
