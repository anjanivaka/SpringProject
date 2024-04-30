package com.cg.petshop.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.petshop.bean.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Integer>{
	
}
