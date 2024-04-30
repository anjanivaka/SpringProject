package com.cg.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.petshop.service.*;
import com.cg.petshop.bean.*;
import com.cg.petshop.exceptions.SuccessResponse;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@GetMapping
	public List<Addresses> getAllAddresses()
	{
		return addressService.getAllAddresses();
		
	}
	@GetMapping("/{addressId}")
	public Addresses getAddressesById(@PathVariable("addressId") Integer addressId)
	{
		return addressService.getAddressById(addressId);
		
	}
	@PostMapping("/add")
	public SuccessResponse addAddress(@RequestBody Addresses address)
	{
		return addressService.addAddress(address);
		
	}
	@PutMapping("/update/{address_id}")
	public SuccessResponse updateAddress(@PathVariable("address_id") Integer address_id,@RequestBody Addresses address)
	{
		return addressService.updateAddress(address_id,address);
		
	}

}
