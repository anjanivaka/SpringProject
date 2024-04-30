package com.cg.petshop.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cg.petshop.bean.Addresses;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.AddressAndSuppliers.AddressIdNotFoundException;
import com.cg.petshop.exceptions.AddressAndSuppliers.AddressInputInvalidException;
import com.cg.petshop.exceptions.AddressAndSuppliers.AddressNotFoundException;
import com.cg.petshop.repo.AddressRepository;
import com.cg.petshop.serviceinterface.AddressServiceInterface;
@Service
public class AddressService implements AddressServiceInterface{
	@Autowired
	private AddressRepository addressRepo;
	public List<Addresses> getAllAddresses()
	{
		try
		{
			return addressRepo.findAll();
		}
		catch(AddressNotFoundException ex)
		{
			 throw new AddressIdNotFoundException("Validation Failed {Address list is Empty}");
		}
		
	}
	public Addresses getAddressById(int address_id) throws AddressIdNotFoundException
	{
		try
		{
			Addresses address=addressRepo.findById(address_id).get();
			
			return address;
		}
		catch(NoSuchElementException ex)
		{
			 throw new AddressIdNotFoundException("Validation Failed");
		}
		
			
	}
	
	public SuccessResponse addAddress(Addresses address) throws AddressNotFoundException
	{
		try
		{
			Addresses addressobj =addressRepo.save(address);
			SuccessResponse sucres=new SuccessResponse();
			sucres.setMessage("Addresss updated Successfully"+addressobj);
			sucres.setTimestamp(LocalDate.now());
			sucres.setStatus(HttpStatus.ACCEPTED.toString());
			return sucres;
		}
		catch(AddressNotFoundException ex)
		{
			throw new AddressNotFoundException("Validation Failed");
		}
		
	}
	public SuccessResponse updateAddress(int address_id,Addresses updatedAddress) 
	{
		
		try
		{
			Addresses address=addressRepo.findById(address_id).get();
			if(address!=null)
			{
				address.setStreet(updatedAddress.getStreet());
				address.setCity(updatedAddress.getCity());
				address.setState(updatedAddress.getState());
				address.setZipCode(updatedAddress.getZipCode());
			}
			addressRepo.save(address);
			SuccessResponse sucres=new SuccessResponse();
			sucres.setMessage("Addresss updated Successfully"+address);
			sucres.setTimestamp(LocalDate.now());
			sucres.setStatus(HttpStatus.ACCEPTED.toString());
			return sucres;
		}
		catch(NoSuchElementException ex)
		{
			throw new AddressIdNotFoundException("Validation Failed {Invalid Id}");
		}
		
	}

}
