package com.cg.petshop.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cg.petshop.bean.Suppliers;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierCityNotFoundException;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierIdNotFoundException;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierInputInvalidException;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierNameNotFoundException;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierNotFoundException;
import com.cg.petshop.repo.SuppliersRepository;
import com.cg.petshop.serviceinterface.SuppliersServiceInterface;
@Service
public class SuppliersService implements SuppliersServiceInterface{
	@Autowired
	SuppliersRepository suppliersRepo;
	
	public List<Suppliers> getAllSuppliers()
	{
		List<Suppliers> suppliers=suppliersRepo.findAll();
		if(suppliers.isEmpty())
			throw new SupplierNotFoundException("Validation Failed {No suppliers are present}");
		return suppliers; 
		
	}
	public Suppliers getSupplierById(int supplierId) throws SupplierIdNotFoundException
	{
		try
		{
			Suppliers supplier=suppliersRepo.findById(supplierId).get();
			return supplier;
		}
		catch(NoSuchElementException  ex)
		{
			throw new SupplierIdNotFoundException("Validation Failed");
		}
		
	}
	
	
	public List<Suppliers> getSuppliersByName(String name) throws SupplierNameNotFoundException
	{
			List<Suppliers> supplier=suppliersRepo.findByName(name);
			if(supplier.isEmpty())
				throw new SupplierNameNotFoundException("Validation Failed");
			return supplier;
		
	}
	
	
	public List<Suppliers> getSuppliersByCity(String city) throws SupplierNameNotFoundException {
		List<Suppliers> supplier=suppliersRepo.findByCity(city);
		if(supplier.isEmpty())
			throw new SupplierNameNotFoundException("Validation Failed");
		return supplier;
	}
	
	
	public List<Suppliers> getSuppliersByState(String state) {
		List<Suppliers> supplier=suppliersRepo.findByState(state);
		if(supplier.isEmpty())
			throw new SupplierCityNotFoundException("Validation Failed");
		return supplier;
	}
	
	
	public SuccessResponse addSupplier(Suppliers supplier) throws SupplierInputInvalidException{
		try
		{
			Suppliers supplierobj=suppliersRepo.save(supplier);
			SuccessResponse sucres=new SuccessResponse();
			sucres.setMessage("Supplier Added Successfully"+supplierobj);
			sucres.setTimestamp(LocalDate.now());
			sucres.setStatus(HttpStatus.ACCEPTED.toString());
			return sucres;
		}
		catch(Exception e)
		{
			throw new SupplierInputInvalidException("Validation Failed {Invalid Input}");
		}
        
    }
	
	public SuccessResponse updateSupplierById(int supplierId, Suppliers updatedSupplier)
	{
		try
		{
			Suppliers supplier=suppliersRepo.findById(supplierId).get();
			if(supplier!=null)
			{
				supplier.setName(updatedSupplier.getName());
				supplier.setAddress(updatedSupplier.getAddress());
				supplier.setContactPerson(updatedSupplier.getContactPerson());
				supplier.setEmail(updatedSupplier.getEmail());
				supplier.setPhoneNumber(updatedSupplier.getPhoneNumber());
			}
			suppliersRepo.save(supplier);
			
			SuccessResponse sucres=new SuccessResponse();
			sucres.setMessage("Supplier updated Successfully"+supplier);
			sucres.setTimestamp(LocalDate.now());
			sucres.setStatus(HttpStatus.ACCEPTED.toString());
			return sucres;
		}
		catch(NoSuchElementException ex)
		{
			throw new SupplierIdNotFoundException("Validation Failed ");
		}
		
		
        
    }
}
