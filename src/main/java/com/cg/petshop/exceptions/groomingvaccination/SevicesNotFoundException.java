package com.cg.petshop.exceptions.groomingvaccination;

public class SevicesNotFoundException extends Throwable {

	public SevicesNotFoundException(String message) {
		super(message);
	}

	public SevicesNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public SevicesNotFoundException(String message, Throwable e, boolean enablesupression, boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}
}
