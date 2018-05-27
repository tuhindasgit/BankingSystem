package com.training.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.BankingSystem.model.Denomination;
/**
 * 
 * @author tuhin
 *
 */
public interface DenmRepo extends JpaRepository<Denomination, Integer> {

}
