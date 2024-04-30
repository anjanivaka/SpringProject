package com.cg.petshop.serviceinterface;

import java.util.List;
import com.cg.petshop.bean.Vaccinations;
import com.cg.petshop.exceptions.MismatchDataTypeException;
import com.cg.petshop.exceptions.SuccessResponse;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationInvalidInputException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationsIdNotFoundException;
import com.cg.petshop.exceptions.groomingvaccination.VaccinationsNotFoundException;

public interface VaccinationServiceInterface {
	List<Vaccinations> getAllVaccinations() throws VaccinationsNotFoundException;

	Vaccinations getVaccinationsByServiceId(int vaccinationId)
			throws VaccinationsIdNotFoundException, MismatchDataTypeException;

	List<Vaccinations> getAllVaccinationsAvailable();

	List<Vaccinations> getAllVaccinationsUnavailable();

	SuccessResponse addVaccinationService(Vaccinations vaccinations)
			throws VaccinationInvalidInputException, MismatchDataTypeException;

	SuccessResponse updateVaccinationService(int vaccinationId, Vaccinations updatedVaccinationService)
			throws VaccinationsIdNotFoundException, MismatchDataTypeException;

}
