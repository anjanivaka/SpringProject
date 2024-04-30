package com.cg.petshop.exceptions.pets;

public class NoVaccinationException extends Throwable{
	public NoVaccinationException(String message) {
		super(message);
	}
	public NoVaccinationException(String message,Throwable e) {
		super(message,e);
	}
	public NoVaccinationException(String message,Throwable e,boolean enablesupression,boolean enablestacktrace) {
		super( message,e,enablesupression,enablestacktrace);
	}
}
