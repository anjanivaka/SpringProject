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
import com.cg.petshop.serviceinterface.GroomingServiceInterface;
import com.cg.petshop.bean.GroomingServices;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.groomingvaccination.GroomingServiceInvalidInputException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceAvailableException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceIdNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceUnavailableException;
import com.cg.petshop.exceptions.groomingvaccination.SevicesNotFoundException;

@RestController
@RequestMapping("/api/v1/services")
public class GroomingServiceController {
    @Autowired
    GroomingServiceInterface grooming_service;
    
    //To get all GroomingServices
    @GetMapping
    public List<GroomingServices> retrieveAll() throws SevicesNotFoundException{
		return grooming_service.getAllGroomingServices();
    }
    
    //To get GroomingService by Id
    @GetMapping("/{service_id}")
    public GroomingServices retrieveByGroomingServiceId(@PathVariable("service_id") int serviceId) throws ServiceIdNotFoundException {
		return grooming_service.getGroomingServicesByServiceId(serviceId);
    }
    
    //All available GroomingServices 
    @GetMapping("/available")
    public List<GroomingServices> getAvailableServices() throws ServiceAvailableException{
        return grooming_service.getAvailableGroomingServices();
    }
    
    //All unavailable GroomingServices
    @GetMapping("/unavailable")
    public List<GroomingServices> getUnAvailableServices() throws ServiceUnavailableException {
        return grooming_service.getUnavailableGroomingServices();
    }
    
    //Post method for adding GroomingService
    @PostMapping("/add")
	 public SuccessResponse addGroomingService(@RequestBody GroomingServices groomingservices) throws GroomingServiceInvalidInputException, MismatchDataTypeException {
		return grooming_service.addGroomingService(groomingservices);
	 }
     
    //Update method for GroomingService 
    @PutMapping("/update/{service_id}")
	public SuccessResponse updateGroomingService(@PathVariable("service_id") int serviceId,@RequestBody GroomingServices groomingservice) throws ServiceIdNotFoundException, MismatchDataTypeException{
		return grooming_service.updateGroomingService(serviceId,groomingservice);
	}
}
