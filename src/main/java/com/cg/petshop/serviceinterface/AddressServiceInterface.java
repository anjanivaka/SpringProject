package com.cg.petshop.serviceinterface;

import java.util.List;

import com.cg.petshop.bean.Addresses;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.AddressAndSuppliers.AddressIdNotFoundException;
import com.cg.petshop.exceptions.AddressAndSuppliers.AddressNotFoundException;

public interface AddressServiceInterface {
	List<Addresses> getAllAddresses();
	Addresses getAddressById(int address_id) throws AddressIdNotFoundException;
	SuccessResponse addAddress(Addresses address) throws AddressNotFoundException;
	SuccessResponse updateAddress(int address_id,Addresses updatedAddress);

}
