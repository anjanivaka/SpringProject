package com.cg.petshop.exceptions.groomingvaccination;

public class GroomingServiceInvalidInputException extends Throwable {
	public GroomingServiceInvalidInputException(String message) {
		super(message);
	}

	public GroomingServiceInvalidInputException(String message, Throwable e) {
		super(message, e);
	}

	public GroomingServiceInvalidInputException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}
}
