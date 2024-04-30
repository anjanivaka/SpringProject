package com.cg.petshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.petshop.bean.Employees;
import com.cg.petshop.bean.Vaccinations;

public interface VaccinationRepository extends JpaRepository<Vaccinations, Integer> {
	@Query("select v from Vaccinations v where v.available=1")
	List<Vaccinations> findByAvailable();

	@Query("select v from Vaccinations v where v.available=0")
	List<Vaccinations> findByUnavailable();

}
