package com.cg.petshop.controller;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.petshop.bean.Customers;

import com.cg.petshop.bean.Transactions;
import com.cg.petshop.enums.transaction_status;
import com.cg.petshop.exceptions.CustomerCityNotFoundException;
import com.cg.petshop.exceptions.CustomerFirstnameLastnameNotFoundException;
import com.cg.petshop.exceptions.CustomerIdNotFoundException;
import com.cg.petshop.exceptions.CustomerStateNotFoundException;
import com.cg.petshop.exceptions.CustomerTransactionCustomerIdNotFoundException;
import com.cg.petshop.exceptions.CustomerTransactionStatusNotFoundException;
import com.cg.petshop.exceptions.pets.NoTransactionFoundException;
import com.cg.petshop.bean.Pets;

import com.cg.petshop.service.customerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	@Autowired
	customerService customer_service;
	
	
	@GetMapping
	public List<Customers> retreiveAllC(){
		return customer_service.retreiveAllCustomers();
	}
	

	
	@GetMapping("/{customer_id}")
	public Optional<Customers> getCustomerById(@PathVariable int customer_id) throws CustomerIdNotFoundException{
		return customer_service.getCustomerById(customer_id);
	}

	
	@GetMapping("/by_city/{city}")
	public List<Customers> getCustBycity(@PathVariable String city) throws CustomerCityNotFoundException{
		return customer_service.getCustomerBycity(city);
		
	}
	
	@GetMapping("/by_state/{state}")
	public List<Customers> getCustBystate(@PathVariable String state) throws CustomerStateNotFoundException{
		return customer_service.getCustomerBystate(state);
 
	}
	@GetMapping("/transactions/{customer_id}")
	public List<Transactions> getCustBytranscustid(@PathVariable int customer_id) throws CustomerTransactionCustomerIdNotFoundException{
		return customer_service.getCustomerBytranscustid(customer_id);
 
	}
	 @GetMapping("/transaction_status/{status}")
	    public List<Customers> getCustomersByTransactionStatus(@PathVariable transaction_status status) throws CustomerTransactionStatusNotFoundException, NoTransactionFoundException{
		 if((status.equals(transaction_status.Success)||(status.equals(transaction_status.Failed))))
			{
			 return customer_service.findCustomersByTransactionStatus(status);
			}
		 else
				throw new CustomerTransactionStatusNotFoundException("No transaction found");
			
	    }
	
	 
	 @GetMapping("/no-transactions")
	    public List<Customers> getCustomersByNotransaction()  {
	        return customer_service.findCustomersByNotransaction();
	    }
	
	
	@GetMapping("/name/{first_name}/{last_name}")
	public List<Customers> getCustByfirstNameAndlastName(@PathVariable("first_name") String first_name, @PathVariable ("last_name") String last_name) throws CustomerFirstnameLastnameNotFoundException{
		return customer_service.getCustomerByfirstNameAndLastName(first_name,last_name);
 
	}
	
	@PutMapping("/update/{customers_id}")
	 public Customers updateCustomers(@PathVariable("customers_id") Integer customers_id,@RequestBody Customers customers)
	 {
		return customer_service.updateCustomersById(customers_id,customers);
	 }
	
	@PostMapping("/add")
	 public Customers addCustomers(@RequestBody Customers customers)
	 {
		return customer_service.addCustomers(customers);
	 }
	
	

	@GetMapping("api/v1/customers/pets/{customer_id}")
	public List<Pets> getPetsByCustomerId(@PathVariable int customer_id){
		return customer_service.getAllPetsByCustomerId(customer_id);
	}

}
