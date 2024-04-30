package com.cg.petshop.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerexception(CustomerIdNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerexception(CustomerNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerCityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerexception(CustomerCityNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerStateNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerexception(CustomerStateNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CustomerTransactionCustomerIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerexception(CustomerTransactionCustomerIdNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CustomerTransactionStatusNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerexception(CustomerTransactionStatusNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerFirstnameLastnameNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerexception(CustomerFirstnameLastnameNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}

}
