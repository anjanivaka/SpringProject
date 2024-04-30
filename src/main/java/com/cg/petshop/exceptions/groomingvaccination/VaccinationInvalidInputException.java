package com.cg.petshop.exceptions.groomingvaccination;

public class VaccinationInvalidInputException extends Throwable {
	public VaccinationInvalidInputException(String message) {
		super(message);
	}

	public VaccinationInvalidInputException(String message, Throwable e) {
		super(message, e);
	}

	public VaccinationInvalidInputException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}
}
