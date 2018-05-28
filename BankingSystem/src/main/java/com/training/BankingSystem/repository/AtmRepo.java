package com.training.BankingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.BankingSystem.model.ATM;
import com.training.BankingSystem.model.Bank;
/**
 * 
 * @author tuhin
 *
 */
public interface AtmRepo extends JpaRepository<ATM, Integer> {

	@Query(value="SELECT * FROM ATM where ATMId=?1",nativeQuery=true)
	Optional<ATM> findById(Integer id);
}
