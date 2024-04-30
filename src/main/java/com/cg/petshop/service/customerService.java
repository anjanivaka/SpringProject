package com.cg.petshop.service;

 
import java.util.List;

import java.util.NoSuchElementException;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.petshop.bean.Customers;

import com.cg.petshop.bean.Transactions;
import com.cg.petshop.enums.transaction_status;
import com.cg.petshop.exceptions.CustomerCityNotFoundException;
import com.cg.petshop.exceptions.CustomerFirstnameLastnameNotFoundException;
import com.cg.petshop.exceptions.CustomerIdNotFoundException;
import com.cg.petshop.exceptions.CustomerNotFoundException;
import com.cg.petshop.exceptions.CustomerStateNotFoundException;
import com.cg.petshop.exceptions.CustomerTransactionCustomerIdNotFoundException;
import com.cg.petshop.exceptions.CustomerTransactionStatusNotFoundException;


import com.cg.petshop.bean.Pets;


import com.cg.petshop.repo.CustomerRepository;
import com.cg.petshop.repo.TransactionRepository;

@Service
public class customerService{
	
	@Autowired
	CustomerRepository customer_repo;

	@Autowired
	TransactionRepository transrepo;


	
	@Autowired
	TransactionRepository trans_repo;


	public List<Customers> retreiveAllCustomers(){
		try {
			return customer_repo.findAll();
		}
		catch(NoSuchElementException ex)
		{
			throw new CustomerNotFoundException("Customer not found");
		}
	}
	public Optional<Customers> getCustomerById(int customer_id) throws CustomerIdNotFoundException {
	    Optional<Customers> customerOptional = customer_repo.findById(customer_id);
	    if (customerOptional.isEmpty()) {
	    	throw new CustomerIdNotFoundException("Id not found");
	    } 
	    return customerOptional;
	}

	public List<Customers> getCustomerBycity(String city) throws CustomerCityNotFoundException {
	    List<Customers> customerOptional = customer_repo.findByCity(city);
	    if (customerOptional.isEmpty()) {
	    	throw new CustomerCityNotFoundException("City not found");
	    } 
	    return customerOptional;
	}

	public List<Customers> getCustomerBystate(String state)throws CustomerStateNotFoundException {
		// TODO Auto-generated method stub
		List<Customers> customerOptional = customer_repo.findByState(state);
		if (customerOptional.isEmpty()) {
			throw new CustomerStateNotFoundException("State not found");
		}
		return customerOptional;
	}


	public List<Transactions> getCustomerBytranscustid(int customer_id) throws CustomerTransactionCustomerIdNotFoundException {
	    List<Transactions> customerOptional = customer_repo.findByCustomerId(customer_id);
	    if (customerOptional.isEmpty()) {
	    	throw new CustomerTransactionCustomerIdNotFoundException("TransactionId not found");
	    } 
	    return customerOptional;
	}

	
	
//	public List<Customers> findCustomersByTransactionStatus(transaction_status status) {
//        return customer_repo.findCustomersByTransactionStatus(status);
//    }
	
//	public List<Customers> findCustomerByTransactionstatus(transaction_status status) throws CustomerTransactionStatusNotFoundException {
//	    List<Customers> customerOptional = customer_repo.findCustomersByTransactionStatus(status);
//	    if (customerOptional.isEmpty()) {
//	    	throw new CustomerTransactionStatusNotFoundException("Transaction status not found");
//	    } 
//	    return customerOptional;
//	}
	
	public List<Customers> findCustomersByTransactionStatus(transaction_status status) throws CustomerTransactionStatusNotFoundException{
		
			
				List<Customers> customerOptional = customer_repo.findCustomersByTransactionStatus(status);
				
			      return customerOptional;
			
//			else
//				throw new CustomerTransactionStatusNotFoundException("No transaction found");
//			
			
		}
		
	
	

	public List<Customers> findCustomersByNotransaction() {
		// TODO Auto-generated method stub
		return customer_repo.findCustomerByNotransaction();
	}
	public List<Customers> getCustomerByfirstNameAndLastName(String firstName,String lastName)throws CustomerFirstnameLastnameNotFoundException {
		// TODO Auto-generated method stub
		List<Customers> customerOptional = customer_repo.findCustomerByfirstNameAndlastName(firstName,lastName);
		if (customerOptional.isEmpty()) {
			throw new CustomerFirstnameLastnameNotFoundException("Name not found");
		}
		return customerOptional;
	}
	
	
	
public Customers updateCustomersById(int customersId, Customers updatedCustomers) {
		Customers customers =customer_repo.findById(customersId).get();
		if(customers!=null)
		{
			customers.setFirstName(updatedCustomers.getFirstName());
			customers.setLastName(updatedCustomers.getLastName());
			customers.setAddress(updatedCustomers.getAddress());
			customers.setEmail(updatedCustomers.getEmail());
			customers.setPhoneNumber(updatedCustomers.getPhoneNumber());
		}
		customer_repo.save(customers);
		return updatedCustomers;
    }
	public Customers addCustomers(Customers customer) {
		
			return customer_repo.save(customer);
		
    }
	

	public List<Pets> getAllPetsByCustomerId(int customer_id) {
		// TODO Auto-generated method stub
		Optional<Transactions> t=trans_repo.findById(customer_id);
		
		return null;
	}
}

