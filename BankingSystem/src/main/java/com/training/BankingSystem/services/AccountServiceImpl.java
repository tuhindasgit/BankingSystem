package com.training.BankingSystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Account;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.Customer;
import com.training.BankingSystem.repository.AccountRepo;
import com.training.BankingSystem.repository.BankRepo;
import com.training.BankingSystem.repository.CustomerRepo;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepo accountRepo;
	@Autowired
	BankRepo bankRepo;
	@Autowired
	CustomerRepo custRepo;
	@Override
	public Account createAccount(Account account) {
		Integer customerId=account.getCustomerId();
		Integer bankId=account.getBankId();
		Optional<Bank> bank1=bankRepo.findById(bankId);
		Optional<Customer> customer1=custRepo.findById(customerId);
		if(bank1.isPresent() && customer1.isPresent())
		{
			if(bank1.get().getBankId()==customer1.get().getBankId())
			{
			Account account1=accountRepo.save(account);
			return account1;
			}
			else
			{
				throw new MyException("Bank id Does not matches with customers bank id");
			}
		}
		else
		{
			throw new MyException("bank or customer dose not match");
		}

		
	
	}

	@Override
	public Account getAccountDetails(Integer accountId) {
		
		Optional<Account> account1=accountRepo.findById(accountId);
		if(account1.isPresent())
		{
			return account1.get();
		}
		else
		{
			throw new MyException("Account with this id is not present");
		}
	}

}
