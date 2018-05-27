package com.training.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.BankingSystem.model.ATM;
/**
 * 
 * @author tuhin
 *
 */
public interface AtmRepo extends JpaRepository<ATM, Integer> {

}
