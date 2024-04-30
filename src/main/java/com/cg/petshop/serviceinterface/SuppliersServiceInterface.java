package com.cg.petshop.serviceinterface;

import java.util.List;

import com.cg.petshop.bean.Suppliers;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierIdNotFoundException;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierInputInvalidException;
import com.cg.petshop.exceptions.AddressAndSuppliers.SupplierNameNotFoundException;

public interface SuppliersServiceInterface {
	List<Suppliers> getAllSuppliers();
	Suppliers getSupplierById(int supplierId) throws SupplierIdNotFoundException;
	List<Suppliers> getSuppliersByName(String name) throws SupplierNameNotFoundException;
	List<Suppliers> getSuppliersByCity(String city) throws SupplierNameNotFoundException;
	List<Suppliers> getSuppliersByState(String state);
	SuccessResponse addSupplier(Suppliers supplier) throws SupplierInputInvalidException;
	SuccessResponse updateSupplierById(int supplierId, Suppliers updatedSupplier);

}
