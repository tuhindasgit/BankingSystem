package com.training.BankingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.BankingSystem.model.BankDenomination;
import com.training.BankingSystem.model.Denomination;
/**
 * 
 * @author tuhin
 *
 */
public interface BankDenmRepo extends JpaRepository<BankDenomination, Integer> {
	@Query("SELECT * FROM Denomination where denomination=?")
	Optional<BankDenomination> findById(Integer id);
}
