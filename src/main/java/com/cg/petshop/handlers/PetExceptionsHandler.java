package com.cg.petshop.handlers;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.petshop.exceptions.ErrorResponse;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.pets.NoFoodInfoException;
import com.cg.petshop.exceptions.pets.NoGroomingServiceException;
import com.cg.petshop.exceptions.pets.NoPetsFoundException;
import com.cg.petshop.exceptions.pets.NoSupplierFoundException;
import com.cg.petshop.exceptions.pets.NoTransactionFoundException;
import com.cg.petshop.exceptions.pets.NoVaccinationException;
import com.cg.petshop.exceptions.pets.PetCannotBeAddedException;
import com.cg.petshop.exceptions.pets.PetCategoryNotFoundException;
import com.cg.petshop.exceptions.pets.PetIdNotFoundException;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@ControllerAdvice
public class PetExceptionsHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(PetIdNotFoundException exe){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(PetCategoryNotFoundException exe){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NoPetsFoundException exe){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NoGroomingServiceException exe){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NoVaccinationException exe){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NoTransactionFoundException exe){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NoSupplierFoundException exe){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(PetCannotBeAddedException exe){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NoFoodInfoException exe){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(MismatchDataTypeException exe){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	
//	@ExceptionHandler
//	public ResponseEntity<ErrorResponse> handleException(Exception exe){
//		
//		ErrorResponse err = new ErrorResponse();
//		err.setMessage(exe.getMessage());
//		err.setStatus(HttpStatus.BAD_REQUEST.toString());
//		err.setTimestamp(LocalDate.now());
//		
//		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
//	}


	
}
