package com.cg.petshop.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.petshop.bean.GroomingServices;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.Validationclass;
import com.cg.petshop.exceptions.groomingvaccination.GroomingServiceInvalidInputException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceAvailableException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceIdNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.ServiceUnavailableException;
import com.cg.petshop.exceptions.groomingvaccination.SevicesNotFoundException;
import com.cg.petshop.repo.GroomingServicesRepository;
import com.cg.petshop.serviceinterface.GroomingServiceInterface;

@Service
public class GroomingService implements GroomingServiceInterface {
	@Autowired
	GroomingServicesRepository groomingserviceRepo;

	// To get all GroomingServices
	public List<GroomingServices> getAllGroomingServices() throws SevicesNotFoundException {
		List<GroomingServices> gsl = groomingserviceRepo.findAll();
		if (gsl.isEmpty()) {
			throw new SevicesNotFoundException("Validation failed:No grooming services ");
		}
		return groomingserviceRepo.findAll();
	}

	// To get GroomingService by Id
	public GroomingServices getGroomingServicesByServiceId(int serviceId) throws ServiceIdNotFoundException {
		try {
			GroomingServices gs = groomingserviceRepo.findById(serviceId).get();
			return gs;
		} catch (NoSuchElementException e) {
			throw new ServiceIdNotFoundException("Validation failed:Service Id not found");
		}

	}

	// All available GroomingServices
	public List<GroomingServices> getAvailableGroomingServices() throws ServiceAvailableException {
		List<GroomingServices> ga = groomingserviceRepo.findAllAvailable();
		if (ga.isEmpty()) {
			throw new ServiceAvailableException("Validation failed:No grooming services available ");
		}
		return groomingserviceRepo.findAllAvailable();
	}

	// All unavailable GroomingServices
	public List<GroomingServices> getUnavailableGroomingServices() throws ServiceUnavailableException {
		List<GroomingServices> gu = groomingserviceRepo.findAllUnavailable();
		if (gu.isEmpty()) {
			throw new ServiceUnavailableException("Validation failed:Grooming services unavailable ");
		}
		return groomingserviceRepo.findAllUnavailable();
	}

	// Post method for adding GroomingService
	public SuccessResponse addGroomingService(GroomingServices groomingservices)
			throws GroomingServiceInvalidInputException, MismatchDataTypeException {
		try {
			if (!Validationclass.ValidationInt(groomingservices.getName())) {
				throw new MismatchDataTypeException("Name should be string");
			}
			if (!Validationclass.ValidationInt(groomingservices.getDescription())) {
				throw new MismatchDataTypeException("Description should be string");
			}
			if (!(groomingservices.isAvailable() == 0 || groomingservices.isAvailable() == 1)) {
				throw new MismatchDataTypeException("Invalid available status");
			}
			GroomingServices g = groomingserviceRepo.save(groomingservices);
			SuccessResponse s = new SuccessResponse();
			s.setMessage("Data added" + g);
			s.setStatus("Success");
			s.setTimestamp(LocalDate.now());
			return s;
		} catch (Exception e) {
			throw new GroomingServiceInvalidInputException("Validation failed:Grooming Service cannot be added");
		}

	}

	// Update method for GroomingService
	public SuccessResponse updateGroomingService(int serviceId, GroomingServices updatedgroomingService)
			throws ServiceIdNotFoundException, MismatchDataTypeException {
		try {
			GroomingServices groomingservice = groomingserviceRepo.findById(serviceId).get();
			if (groomingservice != null) {
				if (!Validationclass.ValidationInt(updatedgroomingService.getName())) {
					throw new MismatchDataTypeException("Name should be string");
				}
				if (!Validationclass.ValidationInt(updatedgroomingService.getDescription())) {
					throw new MismatchDataTypeException("Description should be string");
				}

				if (!(updatedgroomingService.isAvailable() == 0 || updatedgroomingService.isAvailable() == 1)) {
					throw new MismatchDataTypeException("Invalid available status");
				}
				if (updatedgroomingService.getName().isEmpty()) {
					throw new MismatchDataTypeException("Name should not be null.{Existing data should not removed}");
				}
				if (updatedgroomingService.getDescription().isEmpty()) {
					throw new MismatchDataTypeException(
							"Description should not be null.{Existing data should not removed}");
				}
				if (updatedgroomingService.getPrice() == null) {
					throw new MismatchDataTypeException("Price should not be null.{Existing data should not removed}");
				}

				groomingservice.setName(updatedgroomingService.getName());
				groomingservice.setDescription(updatedgroomingService.getDescription());
				groomingservice.setPrice(updatedgroomingService.getPrice());
				groomingservice.setAvailable(updatedgroomingService.isAvailable());
				groomingserviceRepo.save(groomingservice);

			}
			SuccessResponse s = new SuccessResponse();
			s.setMessage("Data Updated" + groomingservice);
			s.setStatus("Success");
			s.setTimestamp(LocalDate.now());
			return s;
		}

		catch (NoSuchElementException ex) {
			throw new ServiceIdNotFoundException("Validation Failed:Invalid Vaccination Id");
		}

	}

}
