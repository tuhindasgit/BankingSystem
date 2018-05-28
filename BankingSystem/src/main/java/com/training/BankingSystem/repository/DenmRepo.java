package com.training.BankingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.Denomination;
/**
 * 
 * @author tuhin
 *
 */
public interface DenmRepo extends JpaRepository<Denomination, Integer> {

	@Query(value="SELECT * FROM Denomination where denomination=?",nativeQuery=true)
	Optional<Denomination> findById(Integer id);
}
