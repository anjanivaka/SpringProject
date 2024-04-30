package com.cg.petshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.petshop.bean.Addresses;

public interface AddressRepository extends JpaRepository<Addresses, Integer>{

}
