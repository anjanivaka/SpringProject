package com.cg.petshop.controller.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.petshop.bean.GroomingServices;
import com.cg.petshop.bean.Vaccinations;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.groomingvaccination.GroomingServiceInvalidInputException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceIdNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationInvalidInputException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationsIdNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationsNotFoundException;
import com.cg.petshop.serviceinterface.VaccinationServiceInterface;

@Controller
public class VaccinationThymeleaf {

	@Autowired
	VaccinationServiceInterface vaccinations;

	// Click Page
	@GetMapping("/click")
	public String showClickForm() {
		return "clickForm";
	}

	// Home Page
	@GetMapping("/home")
	public String showHomeForm() {
		return "homeForm";
	}

	// To get all Vaccinations
	@GetMapping("/api1/v1/vaccinations")
	public String retrieveAll(Model model) throws VaccinationsNotFoundException {
		List<Vaccinations> vacc = vaccinations.getAllVaccinations();
		model.addAttribute("allvaccinations", vacc);
		return "allVaccinations";
	}

	// Vaccination Id form
	@GetMapping("/api1/v1/vaccinationId")
	public String showVaccinationIdForm() {
		return "vaccinationForm";
	}

	// To get vaccination by Id
	@GetMapping("/api1/v1/vaccinationId/id")
	public String retrieveByVaccinationId(@RequestParam("vaccinationId") int vaccinationId, Model model)
			throws VaccinationsIdNotFoundException, MismatchDataTypeException {
		Vaccinations vs = vaccinations.getVaccinationsByServiceId(vaccinationId);
		model.addAttribute("vaccinationById", vs);
		return "vaccinationIdDetails";
	}

	// Vaccination Id post form
	@GetMapping("/api1/v1/vaccinationpost")
	public String showVaccinationForm() {
		return "vaccinationPostForm";
	}

	// Post method for vaccination
	@PostMapping("/api1/v1/vaccinations/add")
	public String addVaccinationService(Model model, @ModelAttribute("addVaccinations") Vaccinations vacc)
			throws VaccinationInvalidInputException, MismatchDataTypeException {
		SuccessResponse rs = vaccinations.addVaccinationService(vacc);
		model.addAttribute("addVaccinations", rs);
		return "postVaccinationDetails";
	}

	// put
	@GetMapping("/api1/v1/vaccinationupdate")
	public String showVaccineUpdateForm(Model model) {
		return "groomingVaccinationUpdateForm";
	}

	@GetMapping("/api1/v1/vaccineserviceupdate/id")
	public String showVaccineUpdateIdForm(Model model, @RequestParam("vaccinationId") int vaccinationId)
			throws VaccinationsIdNotFoundException, MismatchDataTypeException {
		Vaccinations gs = vaccinations.getVaccinationsByServiceId(vaccinationId);
		model.addAttribute("gs", gs);
		return "updatevaccinationDetails";
	}

	// Controller method to handle updating a grooming service
	@GetMapping("/api1/v1/vaccineservice/update")
	public String updateVaccine(Model model, @RequestParam("vaccinationId") int vaccinationId,
			@ModelAttribute("updateVaccinationService") Vaccinations gsu)
			throws VaccinationsIdNotFoundException, MismatchDataTypeException {
		SuccessResponse service = vaccinations.updateVaccinationService(vaccinationId, gsu);
		model.addAttribute("service", service);
		return "updateVaccinationServiceDetails"; 
	}

}
