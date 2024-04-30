package com.cg.petshop.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.petshop.bean.Vaccinations;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.Validationclass;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationInvalidInputException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationsIdNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationsNotFoundException;
import com.cg.petshop.repo.VaccinationRepository;
import com.cg.petshop.serviceinterface.VaccinationServiceInterface;

@Service
public class VaccinationService implements VaccinationServiceInterface {
	@Autowired
	private VaccinationRepository vaccinationrepos;

	// To get all Vaccinations
	public List<Vaccinations> getAllVaccinations() throws VaccinationsNotFoundException {
		List<Vaccinations> vsl = vaccinationrepos.findAll();
		if (vsl.isEmpty()) {
			throw new VaccinationsNotFoundException("Validation failed:No vaccination services ");
		}
		return vsl;
	}

	// To get Vaccinations by Id
	public Vaccinations getVaccinationsByServiceId(int vaccinationId)
			throws VaccinationsIdNotFoundException, MismatchDataTypeException {
		try {

			Vaccinations vs = vaccinationrepos.findById(vaccinationId).get();
			return vs;
		} catch (NoSuchElementException e) {
			throw new VaccinationsIdNotFoundException("Validation Failed:Vaccination Id not found");
		}
	}

	// All available Vaccinations
	public List<Vaccinations> getAllVaccinationsAvailable() {
		// TODO Auto-generated method stub
		return vaccinationrepos.findByAvailable();
	}

	// All unavailavle Vaccinations
	public List<Vaccinations> getAllVaccinationsUnavailable() {
		// TODO Auto-generated method stub
		return vaccinationrepos.findByUnavailable();
	}

	// Post method for adding Vaccination
	public SuccessResponse addVaccinationService(Vaccinations vaccinations)
			throws VaccinationInvalidInputException, MismatchDataTypeException {
		try {
			if (!Validationclass.ValidationInt(vaccinations.getName())) {
				throw new MismatchDataTypeException("Name shoutld be string");
			}
			if (!Validationclass.ValidationInt(vaccinations.getDescription())) {
				throw new MismatchDataTypeException("Description should be string");
			}
			if (!(vaccinations.isAvailable() == 0 || vaccinations.isAvailable() == 1)) {
				throw new MismatchDataTypeException("Invalid value");
			}

			Vaccinations v = vaccinationrepos.save(vaccinations);
			SuccessResponse s = new SuccessResponse();
			s.setMessage("Data added" + v);
			s.setStatus("Success");
			s.setTimestamp(LocalDate.now());
			return s;
		} catch (Exception e) {
			throw new VaccinationInvalidInputException("Validation failed:Vaccination cannot be added");
		}
	}

	// Update method for Vaccination
	public SuccessResponse updateVaccinationService(int vaccinationId, Vaccinations updatedVaccinationService)
			throws VaccinationsIdNotFoundException, MismatchDataTypeException {
		try {
			Vaccinations vaccinationservice = vaccinationrepos.findById(vaccinationId).get();
			if (vaccinationservice != null) {
				if (!Validationclass.ValidationInt(updatedVaccinationService.getName())) {
					throw new MismatchDataTypeException("Name should be string");
				}
				if (!Validationclass.ValidationInt(updatedVaccinationService.getDescription())) {
					throw new MismatchDataTypeException("Description should be string");
				}
				if (!(updatedVaccinationService.isAvailable() == 0 || updatedVaccinationService.isAvailable() == 1)) {
					throw new MismatchDataTypeException("Invalid value");
				}
				if (updatedVaccinationService.getName().isEmpty()) {
					throw new MismatchDataTypeException("Name should not be null.{Existing data should not removed}");
				}
				if (updatedVaccinationService.getDescription().isEmpty()) {
					throw new MismatchDataTypeException(
							"Description should not be null.{Existing data should not removed}");
				}
				if (updatedVaccinationService.getPrice() == null) {
					throw new MismatchDataTypeException("Price should not be null.{Existing data should not removed}");
				}
				vaccinationservice.setName(updatedVaccinationService.getName());
				vaccinationservice.setDescription(updatedVaccinationService.getDescription());
				vaccinationservice.setPrice(updatedVaccinationService.getPrice());
				vaccinationservice.setAvailable(updatedVaccinationService.isAvailable());
			}
			vaccinationrepos.save(vaccinationservice);

			SuccessResponse s = new SuccessResponse();
			s.setMessage("Data Updated" + vaccinationservice);
			s.setStatus("Success");
			s.setTimestamp(LocalDate.now());
			return s;
		} catch (NoSuchElementException exe) {
			throw new VaccinationsIdNotFoundException("Validation Failed:Invalid Vaccination Id");
		}
	}
}
