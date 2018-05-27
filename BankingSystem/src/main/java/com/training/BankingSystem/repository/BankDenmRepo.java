package com.training.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.BankingSystem.model.BankDenomination;
/**
 * 
 * @author tuhin
 *
 */
public interface BankDenmRepo extends JpaRepository<BankDenomination, Integer> {

}
