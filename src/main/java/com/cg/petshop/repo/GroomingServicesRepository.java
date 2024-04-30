package com.cg.petshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.petshop.bean.GroomingServices;

public interface GroomingServicesRepository extends JpaRepository<GroomingServices, Integer> {
	@Query("select g from GroomingServices g where g.available=1")
	List<GroomingServices> findAllAvailable();

	@Query("select g from GroomingServices g where g.available=0")
	List<GroomingServices> findAllUnavailable();
}
