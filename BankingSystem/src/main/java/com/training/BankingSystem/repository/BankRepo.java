package com.training.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.BankingSystem.model.Bank;

/**
 * @author tuhin
 *
 */
public interface BankRepo extends JpaRepository<Bank,Integer>{
}
