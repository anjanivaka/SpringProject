package com.cg.petshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.petshop.bean.Pets;

public interface PetsRepository extends JpaRepository<Pets, Integer>{

	List<Pets> findByCategoryName(String category);

}
