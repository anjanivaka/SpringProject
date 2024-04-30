package com.cg.petshop.exceptions.groomingvaccination;

public class VaccinationsIdNotFoundException extends Throwable {

	public VaccinationsIdNotFoundException(String message) {
		super(message);
	}

	public VaccinationsIdNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public VaccinationsIdNotFoundException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
