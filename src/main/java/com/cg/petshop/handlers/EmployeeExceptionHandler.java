package com.cg.petshop.handlers;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cg.petshop.exceptions.ErrorResponse;
import com.cg.petshop.exceptions.EmployeeIdNotFoundException;
import com.cg.petshop.exceptions.EmployeeNameNotFoundException;
import com.cg.petshop.exceptions.EmployeeNotFoundException;
import com.cg.petshop.exceptions.EmployeePositionNotFoundException;


@ControllerAdvice
public class EmployeeExceptionHandler {
	@ExceptionHandler
	//@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse>handleException(EmployeeNotFoundException exe)
	{
		 
	ErrorResponse err=new ErrorResponse();
	err.setMessage(exe.getMessage());
	err.setStatus(HttpStatus.NOT_FOUND.toString());
	err.setTimestamp(LocalDate.now());	 
	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	 
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse>handleException(EmployeeIdNotFoundException exe)
	{
		 
	ErrorResponse err=new ErrorResponse();
	err.setMessage(exe.getMessage());
	err.setStatus(HttpStatus.NOT_FOUND.toString());
	err.setTimestamp(LocalDate.now());	 
	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	 
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse>handleException(EmployeeNameNotFoundException exe)
	{
		 
	ErrorResponse err=new ErrorResponse();
	err.setMessage(exe.getMessage());
	err.setStatus(HttpStatus.NOT_FOUND.toString());
	err.setTimestamp(LocalDate.now());	 
	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	 
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse>handleException(EmployeePositionNotFoundException exe)
	{
		 
	ErrorResponse err=new ErrorResponse();
	err.setMessage(exe.getMessage());
	err.setStatus(HttpStatus.NOT_FOUND.toString());
	err.setTimestamp(LocalDate.now());	 
	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	 
	}
	
//	@ExceptionHandler
//	public ResponseEntity<ErrorResponse>handleException(Exception exe)
//	{
//
//	ErrorResponse err=new ErrorResponse();
//	err.setMessage(exe.getMessage());
//	err.setStatus(HttpStatus.BAD_REQUEST.toString());
//	err.setTimestamp(LocalDate.now());
//	 
//	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
// 
//	}
//	

}

