package com.cg.petshop.handlers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.petshop.exceptions.ErrorResponse;
import com.cg.petshop.exceptions.AddressAndSuppliers.AddressIdNotFoundException;
import com.cg.petshop.exceptions.AddressAndSuppliers.AddressInputInvalidException;
import com.cg.petshop.exceptions.AddressAndSuppliers.AddressNotFoundException;

import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierCityNotFoundException;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierIdNotFoundException;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierInputInvalidException;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierNameNotFoundException;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierNotFoundException;

@ControllerAdvice
public class AddressesAndSuppliersExceptionHandler {
	@ExceptionHandler(SupplierIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerexception(SupplierIdNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerexception(SupplierNameNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerexception(SupplierCityNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerexception(SupplierNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerexception(AddressIdNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerexception(AddressNotFoundException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerexception(SupplierInputInvalidException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerexception(AddressInputInvalidException ex)
	{
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
//	@ExceptionHandler
//	public ResponseEntity<ErrorResponse> handlerexception(Exception ex)
//	{
//		ErrorResponse err=new ErrorResponse();
//		err.setMessage(ex.getMessage());
//		err.setStatus(HttpStatus.BAD_REQUEST.toString());
//		err.setTimestamp(LocalDate.now());
//		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
//		
//	}
	
	

	
}
