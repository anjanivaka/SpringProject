package com.cg.petshop.handlers;

import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cg.petshop.exceptions.ErrorResponse;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.groomingvaccination.GroomingServiceInvalidInputException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceAvailableException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceIdNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceUnavailableException;
import com.cg.petshop.exceptions.groomingvaccination.SevicesNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationInvalidInputException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationsIdNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationsNotFoundException;

@ControllerAdvice
public class GroomingVaccinationHandler {

	// Services Not Found Exception
	@ExceptionHandler(SevicesNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleServicesNotFoundException(SevicesNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		error.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// ServiceId Not Found Exception
	@ExceptionHandler(ServiceIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleServiceIdNotFoundException(ServiceIdNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		error.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// Service Available Exception
	@ExceptionHandler(ServiceAvailableException.class)
	public ResponseEntity<ErrorResponse> handleServiceAvailableException(ServiceAvailableException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		error.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// Service Unavailable Exception
	@ExceptionHandler(ServiceUnavailableException.class)
	public ResponseEntity<ErrorResponse> handleServiceUnavailableException(ServiceUnavailableException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		error.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// Grooming Service Add Exception
	@ExceptionHandler(GroomingServiceInvalidInputException.class)
	public ResponseEntity<ErrorResponse> handleGroomingServiceAddedException(
			GroomingServiceInvalidInputException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		error.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// Vaccinations Not Found Exception
	@ExceptionHandler(VaccinationsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleVaccinationsNotFoundException(VaccinationsNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		error.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// Vaccination Id Not Found Exception
	@ExceptionHandler(VaccinationsIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleVaccinationsIdNotFoundException(
			VaccinationsIdNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		error.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// Vaccination Service Add Exception
	@ExceptionHandler(VaccinationInvalidInputException.class)
	public ResponseEntity<ErrorResponse> handleVaccinationServiceInvalidInputException(
			VaccinationInvalidInputException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		error.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MismatchDataTypeException.class)
	public ResponseEntity<ErrorResponse> handleException(MismatchDataTypeException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		error.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
