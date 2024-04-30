package com.cg.petshop.exceptions.groomingvaccination;

public class VaccinationsNotFoundException extends Throwable {

	public VaccinationsNotFoundException(String message) {
		super(message);
	}

	public VaccinationsNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public VaccinationsNotFoundException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
