package com.cg.petshop.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.petshop.bean.Customers;
import com.cg.petshop.bean.Transactions;
import com.cg.petshop.enums.transaction_status;

public interface CustomerRepository extends JpaRepository<Customers, Integer>{
	Optional<Customers> findById(int customer_id);


		@Query("SELECT c FROM Customers c JOIN c.address address WHERE address.city = :city")
		List<Customers> findByCity(@Param("city") String city);

		@Query("SELECT c FROM Customers c JOIN c.address address WHERE address.state = :state")
		List<Customers> findByState(String state);

		@Query("SELECT t FROM Transactions t WHERE t.customer.customerId = :customer_id")
		List<Transactions> findByCustomerId(@Param("customer_id") int customer_id);

		@Query("SELECT DISTINCT t.customer FROM Transactions t WHERE t.transactionStatus = :transactionStatus")
	    List<Customers> findCustomersByTransactionStatus(@Param("transactionStatus") transaction_status status);

		@Query("SELECT c FROM Customers c WHERE c NOT IN (SELECT t.customer FROM Transactions t)")
		List<Customers> findCustomerByNotransaction();

		@Query("SELECT c FROM Customers c WHERE c.firstName = :firstName AND c.lastName = :lastName")
	    List<Customers> findCustomerByfirstNameAndlastName(String firstName, String lastName);


		Optional<Customers> findBycustomerId(int customersId);


	    																									
	
}
