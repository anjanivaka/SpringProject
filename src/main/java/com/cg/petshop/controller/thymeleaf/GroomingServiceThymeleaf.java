package com.cg.petshop.controller.thymeleaf;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.petshop.bean.GroomingServices;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.groomingvaccination.GroomingServiceInvalidInputException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceAvailableException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceIdNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceUnavailableException;
import com.cg.petshop.exceptions.groomingvaccination.SevicesNotFoundException;
import com.cg.petshop.serviceinterface.GroomingServiceInterface;

@Controller
public class GroomingServiceThymeleaf {

	@Autowired
	GroomingServiceInterface grooming_serv;

	// To get all GroomingServices
	@GetMapping("/api1/v1/groomingservice")
	public String retrieveAll(Model model) throws SevicesNotFoundException {
		List<GroomingServices> GroomingServiceList = grooming_serv.getAllGroomingServices();
		model.addAttribute("AllGroomingServices", GroomingServiceList);
		return "groomingServiceList";
	}

	// To get groomingservice By Id Form
	@GetMapping("/api1/v1/groomingserviceId")
	public String showServiceIdForm() {
		return "groomingServiceForm";
	}

	// To get grooming service By Id
	@GetMapping("/api1/v1/groomingserviceId/id")
	public String retrieveByGroomingServiceId(@RequestParam("serviceId") int serviceId, Model model)
			throws ServiceIdNotFoundException {
		GroomingServices gs = grooming_serv.getGroomingServicesByServiceId(serviceId);
		model.addAttribute("groomingId", gs);
		return "serviceIdDetails";
	}

	// To get available grooming services
	@GetMapping("api1/v1/groomingservice/available")
	public String getAvailableServices(Model model) throws ServiceAvailableException {
		List<GroomingServices> gsa = grooming_serv.getAvailableGroomingServices();
		model.addAttribute("availableGroomingServices", gsa);
		return "availableGroomingServices";
	}

	// To get unavailable grooming services
	@GetMapping("api1/v1/groomingservice/unavailable")
	public String getUnAvailableServices(Model model) throws ServiceUnavailableException {
		List<GroomingServices> gsu = grooming_serv.getUnavailableGroomingServices();
		model.addAttribute("unavailableGroomingServices", gsu);
		return "unavailablegs";
	}

	// Grooming service post form
	@GetMapping("/api1/v1/groomingservicepost")
	public String showServiceForm() {
		return "groomingServicePostForm";
	}

	// Post method for adding GroomingService
	@PostMapping("/api1/v1/groomingservice/add")
	public String addGroomingService(Model model, @ModelAttribute("addGroomingService") GroomingServices gs1)
			throws GroomingServiceInvalidInputException, MismatchDataTypeException {
		SuccessResponse sr = grooming_serv.addGroomingService(gs1);
		model.addAttribute("addGroomingService", sr);
		return "postGroomingService";
	}

	// Update form
	@GetMapping("/api1/v1/groomingserviceupdate")
	public String showServiceUpdateForm(Model model) {
		return "groomingServiceUpdateForm";
	}

	// UpdateId form
	@GetMapping("/api1/v1/groomingserviceupdate/id")
	public String showServiceUpdateIdForm(Model model, @RequestParam("serviceId") int serviceId)
			throws ServiceIdNotFoundException {
		GroomingServices gs = grooming_serv.getGroomingServicesByServiceId(serviceId);
		model.addAttribute("gs", gs);
		return "updateDetails";
	}

	// Updating a grooming service
	@GetMapping("/api1/v1/groomingservice/update")
	public String updateGroomingService(Model model, @RequestParam("serviceId") int serviceId,
			@ModelAttribute("updateGroomingService") GroomingServices gsu)
			throws ServiceIdNotFoundException, MismatchDataTypeException {
		SuccessResponse service = grooming_serv.updateGroomingService(serviceId, gsu);
		model.addAttribute("service", service);
		return "updateGroomingServiceDetails"; 
	}

}
