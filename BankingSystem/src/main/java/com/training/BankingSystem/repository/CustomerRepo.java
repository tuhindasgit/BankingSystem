package com.training.BankingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.Customer;

/**
 * @author tuhin
 *
 */
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	@Query("SELECT * FROM Customer where customerId=?")
	Optional<Customer> findById(Integer id);
}
