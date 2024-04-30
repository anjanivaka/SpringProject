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

import com.cg.petshop.service.SuppliersService;
import com.cg.petshop.bean.Suppliers;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierNameNotFoundException;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SuppliersController {
	@Autowired
	SuppliersService supservice;
	
	@GetMapping
	public List<Suppliers> retreiveAllSuppliers()
	{
		return supservice.getAllSuppliers();
	}
	@GetMapping("/{supplierId}")
	public Suppliers retrieveSupplierBySupplierId(@PathVariable("supplierId") Integer supplierId)
	{
		
		
		return supservice.getSupplierById(supplierId);
		
	}
	@GetMapping("/name/{name}")
	public List<Suppliers> retrieveSupplierBySupplierName(@PathVariable("name") String name) throws SupplierNameNotFoundException 
	{
		
			return supservice.getSuppliersByName(name);
		
		
	}
	 @GetMapping("/city/{cityName}")
	    public List<Suppliers> getSuppliersByCity(@PathVariable("cityName") String cityName) throws SupplierNameNotFoundException {
	        return supservice.getSuppliersByCity(cityName);
	    }
	 @GetMapping("/state/{state}")
	    public List<Suppliers> getSuppliersByState(@PathVariable("state") String state) {
	        return supservice.getSuppliersByState(state);
	    }
	 @PostMapping("/add")
	 public SuccessResponse addSupplier(@RequestBody Suppliers supplier)
	 {
		return supservice.addSupplier(supplier);
		 
	 }
	 
	 @PutMapping("/update/{supplier-id}")
	 public SuccessResponse  updateSupplier(@PathVariable("supplier-id") Integer supplierId,@RequestBody Suppliers supplier)
	 {
		
		return supservice.updateSupplierById(supplierId, supplier);
		 
	 }
	
}
