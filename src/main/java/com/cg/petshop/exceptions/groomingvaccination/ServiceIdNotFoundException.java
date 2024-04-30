package com.cg.petshop.exceptions.groomingvaccination;

public class ServiceIdNotFoundException extends Throwable {

	public ServiceIdNotFoundException(String message) {
		super(message);
	}

	public ServiceIdNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public ServiceIdNotFoundException(String message, Throwable e, boolean enablesupression, boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
