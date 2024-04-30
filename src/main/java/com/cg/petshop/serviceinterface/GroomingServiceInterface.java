package com.cg.petshop.serviceinterface;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.petshop.bean.GroomingServices;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.groomingvaccination.GroomingServiceInvalidInputException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceAvailableException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceIdNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceUnavailableException;
import com.cg.petshop.exceptions.groomingvaccination.SevicesNotFoundException;

public interface GroomingServiceInterface {
	List<GroomingServices> getAllGroomingServices() throws SevicesNotFoundException;

	GroomingServices getGroomingServicesByServiceId(int serviceId) throws ServiceIdNotFoundException;

	List<GroomingServices> getAvailableGroomingServices() throws ServiceAvailableException;

	List<GroomingServices> getUnavailableGroomingServices() throws ServiceUnavailableException;

	SuccessResponse addGroomingService(GroomingServices groomingservices)
			throws GroomingServiceInvalidInputException, MismatchDataTypeException;

	SuccessResponse updateGroomingService(int serviceId, GroomingServices updatedgroomingService)
			throws ServiceIdNotFoundException, MismatchDataTypeException;
}
