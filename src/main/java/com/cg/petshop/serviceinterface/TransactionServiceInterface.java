package com.cg.petshop.serviceinterface;

import java.util.List;

import com.cg.petshop.bean.Transactions;
import com.cg.petshop.bean.Vaccinations;

public interface TransactionServiceInterface {
	
	public List<Transactions> retreiveAllTransactions();
	public List<Vaccinations> getAllVaccinationsAvailable();
	public Transactions retreiveCustById(int customerId) ;
	public List<Transactions> retrieveAllCancelledTransactions();

	public List<Transactions> retrieveAllsuccessfulTransactions();

	

}
