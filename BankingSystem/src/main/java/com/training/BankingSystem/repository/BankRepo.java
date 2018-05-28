package com.training.BankingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.BankingSystem.model.Bank;

/**
 * @author tuhin
 *
 */
public interface BankRepo extends JpaRepository<Bank,Integer>{

	Optional<Bank> findByBankId(Integer id);
}
