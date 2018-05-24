package com.training.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.BankingSystem.model.Customer;

/**
 * @author tuhin
 *
 */
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
