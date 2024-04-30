package com.cg.petshop.exceptions.groomingvaccination;

public class ServiceAvailableException extends Throwable {
	public ServiceAvailableException(String message) {
		super(message);
	}

	public ServiceAvailableException(String message, Throwable e) {
		super(message, e);
	}

	public ServiceAvailableException(String message, Throwable e, boolean enablesupression, boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}
}
