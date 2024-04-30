package com.cg.petshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.petshop.bean.Suppliers;

public interface SuppliersRepository extends JpaRepository<Suppliers, Integer>{
	List<Suppliers> findByName(String name);

	
	 @Query("SELECT s FROM Suppliers s JOIN s.address a WHERE a.city = :city")
	 List<Suppliers> findByCity(@Param("city") String city);

	@Query("SELECT s FROM Suppliers s JOIN s.address a WHERE a.state = :state")
	List<Suppliers> findByState(@Param("state") String state);
	}


