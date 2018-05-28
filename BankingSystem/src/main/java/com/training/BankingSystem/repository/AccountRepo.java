package com.training.BankingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.BankingSystem.model.Account;
import com.training.BankingSystem.model.Customer;
/**
 * 
 * @author tuhin
 *
 */
public interface AccountRepo extends JpaRepository<Account, Integer> {

	@Query(value="SELECT * FROM Account where accountId=?1",nativeQuery=true)
	Optional<Account> findById(Integer id);
}
