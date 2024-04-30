package com.cg.petshop.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.petshop.bean.PetCategories;
import com.cg.petshop.bean.Transactions;
import com.cg.petshop.enums.transaction_status;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.Validationclass;
import com.cg.petshop.exceptions.categorytransaction.CategoryAddException;
import com.cg.petshop.exceptions.categorytransaction.CategoryIdNotFoundException;
import com.cg.petshop.exceptions.categorytransaction.CategoryNotFoundException;
import com.cg.petshop.exceptions.categorytransaction.CustomerIdNotFoundException;
import com.cg.petshop.exceptions.categorytransaction.FailedTransNotFoundException;
import com.cg.petshop.exceptions.categorytransaction.SuccessTransNotFoundException;
import com.cg.petshop.exceptions.categorytransaction.TransactionCannotbeAddedException;
import com.cg.petshop.exceptions.categorytransaction.TransactionsIdNotFoundException;
import com.cg.petshop.exceptions.categorytransaction.TransactionsNotFoundException;
import com.cg.petshop.repo.PetCatogeriesRepository;
import com.cg.petshop.repo.TransactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TransactionService {
	
	

			@Autowired
			TransactionRepository transaction_repo;

			
			//get all
			public List<Transactions> retreiveAllTransactions(){
				//return transaction_repo.findAll();
				List<Transactions> trans = transaction_repo.findAll();
				if(trans.isEmpty())
					throw new TransactionsNotFoundException("Validation failed");
				return trans;
			}
					
			
			//get by transId
			public Transactions retreiveTransById(int transactionId) {
				try {
					Transactions trans = transaction_repo.findById(transactionId).get();
					return trans;
				}
				catch(NoSuchElementException e) {
			    		throw new TransactionsIdNotFoundException("Validation Failed");
			    		//return transaction_repo.findById(transactionId).get();
			    	}
			}
			
			//get by custId
			public Transactions retreiveCustById(int customerId) throws CustomerIdNotFoundException {
				try {
					Transactions trans1 = transaction_repo.findById(customerId).get();
					return trans1;
				}
				catch(NoSuchElementException e) {
			    		throw new CustomerIdNotFoundException("Validation Failed");
			    		//return transaction_repo.findById(transactionId).get();
			    	}
			}
			
			//failed			
			public List<Transactions> retrieveAllCancelledTransactions() throws FailedTransNotFoundException {
		        List<Transactions> cancelledTransactions = new ArrayList<>();
		        //List<Transactions> allTransactions = transactionRepo.findAll();
		        for (Transactions transaction : retreiveAllTransactions()) {
		            if (transaction.getTransactionStatus() == transaction_status.Failed) {
		            	cancelledTransactions.add(transaction);
		            }
		        }
		        if (cancelledTransactions.isEmpty()) {
		        	 throw new FailedTransNotFoundException("Validation Failed");
		        }
		        return cancelledTransactions;
		    }
		
			

			
			//success
			public List<Transactions> retrieveAllSuccessfulTransactions() throws SuccessTransNotFoundException {
		        List<Transactions> successfulTransactions = new ArrayList<>();
		        
		        for (Transactions transaction : retreiveAllTransactions()) {
		            if (transaction.getTransactionStatus() == transaction_status.Success) {
		                successfulTransactions.add(transaction);
		            }
		        }
		        if (successfulTransactions.isEmpty()) {
		            throw new SuccessTransNotFoundException("Validation Failed");
		        }
		        return successfulTransactions;
		    }

//			//post
//			public SuccessResponse addTransaction(Transactions transaction) {
//				try {
//					Transactions transobj = transaction_repo.save(transaction);
//					SuccessResponse s=new SuccessResponse();
//					s.setMessage("Data Updated"+transobj);
//					s.setStatus("Success"); 
//
//							s.setTimestamp(LocalDate.now());
//
//							return s;
//				}
//				catch(Exception e) {
//					throw new TransactionCannotbeAddedException("Validation Failed"); 
//				}
//		        //return transaction_repo.save(transaction);
//			}
//			
//	
			

		

			public SuccessResponse addTransaction(Transactions transaction) throws MismatchDataTypeException {
			    try {
			        // Perform validation
			        if (!Validationclass.isValidDateFormat(transaction.getTransactionDate())) {
			            throw new MismatchDataTypeException("Invalid status format");
			        }

		        if(Validationclass.validateTransactionStatus(transaction.getTransactionStatus())) { // Enum value passed
			        	throw new MismatchDataTypeException("Invalid date format");
			        }

			        Transactions transobj = transaction_repo.save(transaction);
			        SuccessResponse s = new SuccessResponse();
			        s.setMessage("Data Updated" + transobj);
			        s.setStatus("Success");
			        s.setTimestamp(LocalDate.now());
			        return s;
			    } catch (MismatchDataTypeException e) {
			        throw e;
			    } catch (Exception e) {
			        throw new TransactionCannotbeAddedException("Validation Failed");
			    }
			}
}




			







