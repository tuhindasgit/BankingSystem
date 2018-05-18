package com.training.BankingSystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.model.Account;
import com.training.BankingSystem.model.Transaction;
import com.training.BankingSystem.repository.TransactionRepo;
/*
 * Services for Transactional services
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepo transRepo;
	
	@Autowired
	Transaction transaction;
	

	@Override
	public List<Transaction> generateTransactionReport() {
		
		return transRepo.findAll();
	}

/*
 * (non-Javadoc)
 * @see com.training.BankingSystem.services.TransactionService#createTransaction(com.training.BankingSystem.model.Account, java.lang.String)
 */
	@Override
	@Transactional
	public Transaction createTransaction(final Account account,final String message) {
		transaction.setAccountId(account.getAccountId());
		transaction.setCustomerId(account.getCustomerId());
		transaction.setAmmount(account.getAmmount());
		transaction.setTransactionType(message);
		transRepo.save(transaction);
		
		return transaction;
		
		
	}

}
