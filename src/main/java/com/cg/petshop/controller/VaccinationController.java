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
import com.cg.petshop.bean.Vaccinations;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationInvalidInputException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationsIdNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationsNotFoundException;
import com.cg.petshop.service.VaccinationService;
import com.cg.petshop.serviceinterface.VaccinationServiceInterface;

@RestController
@RequestMapping("/api/v1/vaccinations")
public class VaccinationController {
	@Autowired
	private VaccinationServiceInterface vac_service;
	
	//To get all Vaccinations
	@GetMapping
	public List<Vaccinations> retrieveAll() throws VaccinationsNotFoundException{
		return vac_service.getAllVaccinations();	
	}
	
	//To get Vaccinations by Id
	@GetMapping("/{vaccinationId}")
	public Vaccinations retrieveByVaccinationId(@PathVariable("vaccinationId") int vaccinationId) throws VaccinationsIdNotFoundException, MismatchDataTypeException {
		return vac_service.getVaccinationsByServiceId(vaccinationId);
	}
	
	//All available Vaccinations
	@RequestMapping("/available")
	public List<Vaccinations> getAllVacAvailable(){
		return vac_service.getAllVaccinationsAvailable();
	}
	
	//All unavailavle Vaccinations
	@RequestMapping("/unavailable")
	public List<Vaccinations> getAllVacUnavailable(){
		return vac_service.getAllVaccinationsUnavailable();
	}
	
	//Post method for adding Vaccination
	@PostMapping("/add")
	 public SuccessResponse addVaccinationService(@RequestBody Vaccinations vaccinations) throws VaccinationInvalidInputException, MismatchDataTypeException{
		return vac_service.addVaccinationService(vaccinations);	
	 }
	 
	 //Update method for Vaccination
	 @PutMapping("/update/{vaccinationId}")
	 public SuccessResponse updateVaccinationService(@PathVariable("vaccinationId") int vaccinationId,@RequestBody Vaccinations vaccinationservice) throws VaccinationsIdNotFoundException, MismatchDataTypeException{
		return vac_service.updateVaccinationService(vaccinationId,vaccinationservice);
	 }
	

}
