package com.cg.petshop.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.petshop.service.TransactionService;

import com.cg.petshop.bean.Transactions;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.categorytransaction.CustomerIdNotFoundException;
import com.cg.petshop.exceptions.categorytransaction.FailedTransNotFoundException;
import com.cg.petshop.exceptions.categorytransaction.SuccessTransNotFoundException;


@RestController
public class TransactionsContoller {

	    @Autowired
		TransactionService transaction_service;
		
	    //get all
		@GetMapping("/api/v1/transaction_history")
		public List<Transactions> retreiveAll(){
			return transaction_service.retreiveAllTransactions();
		}
		
		//get trans_id
		@RequestMapping("/api/v1/transaction_history/{transaction_id}")
		public Transactions retrieveTransactionId(@PathVariable("transaction_id") int transactionId)
		{
			return transaction_service.retreiveTransById(transactionId);
		}
		
		
		
		//get cust_id
		@RequestMapping("/api/v1/transaction_history/by_customer/{customer_id}")
		public Transactions retrieveCustomerId(@PathVariable("customer_id") int customerId) throws CustomerIdNotFoundException
		{
			return transaction_service.retreiveCustById(customerId);
		}
		
		
		//get failed
		@GetMapping("/api/v1/transaction_history/failed")
	    public List<Transactions> retrieveCancelledTransactions() throws FailedTransNotFoundException {
	        return transaction_service.retrieveAllCancelledTransactions();
	    } 
		
		
		//GET successful
		@GetMapping("/api/v1/transaction_history/successful")
	    public List<Transactions> retrieveSuccessfulTransactions() throws SuccessTransNotFoundException {
	        return transaction_service.retrieveAllSuccessfulTransactions();
	    } 
		
		
		
	    //POST
		 @PostMapping("/api/v1/transaction_history/add")
		    public SuccessResponse addTransaction(@RequestBody Transactions transaction) throws MismatchDataTypeException {
		        return transaction_service.addTransaction(transaction);
		    }
		 
		 
	}





