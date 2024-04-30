package com.cg.petshop.exceptions.groomingvaccination;

public class ServiceUnavailableException extends Throwable {
	public ServiceUnavailableException(String message) {
		super(message);
	}

	public ServiceUnavailableException(String message, Throwable e) {
		super(message, e);
	}

	public ServiceUnavailableException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}
}
