package com.training.BankingSystem.services;

import java.math.BigDecimal;
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

	@Override
	public Account withdrawMoney(BigDecimal withdrawl, Integer accountId) {
		Optional<Account> account1=accountRepo.findById(accountId);
		if(account1.isPresent())
		{
			Account acnt1=account1.get();
			Integer bankId=acnt1.getBankId();
			Optional<Bank> opBank1=bankRepo.findById(bankId);
			if(opBank1.isPresent())
			{
				Bank bank1=opBank1.get();
				System.out.println(bank1.getAmount());
			
				if(bank1.getAmount().intValue()>withdrawl.intValue())
				{
					BigDecimal accountAmmount=acnt1.getAmmount().subtract(withdrawl);
					acnt1.setAmmount(accountAmmount);
					accountRepo.save(acnt1);
					BigDecimal bankAmmount=bank1.getAmount().subtract(withdrawl);
					bank1.setAmount(bankAmmount);
					bankRepo.save(bank1);
					return acnt1;
				}
				else
				{
					throw new MyException("you are trying to withdraw invalid ammount");
				}
			}
			else
			{
				throw new MyException("bankId is not associted with this account");
			}

		}
		else
		{
			throw new MyException("Invalid account Id");
		}
	}

	@Override
	public Account depositMoney(BigDecimal deposit, Integer accountId) {
		Optional<Account> account2=accountRepo.findById(accountId);
		if(account2.isPresent())
		{
			Account acnt2=account2.get();
			Integer bankId=acnt2.getBankId();
			Optional<Bank> opBank2=bankRepo.findById(bankId);
			if(opBank2.isPresent())
			{
				Bank bank2=opBank2.get();
				
					BigDecimal accountAmmount=acnt2.getAmmount().add(deposit);
					acnt2.setAmmount(accountAmmount);
					accountRepo.save(acnt2);
					BigDecimal bankAmmount=bank2.getAmount().add(deposit);
					bank2.setAmount(bankAmmount);
					bankRepo.save(bank2);
					return acnt2;
				
			}
			else
			{
				throw new MyException("bankId is not associted with this account");
			}

		}
		else
		{
			throw new MyException("Invalid account Id");
		}
	}

}
