package com.training.BankingSystem.services;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.ATM;
import com.training.BankingSystem.model.Account;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.Customer;
import com.training.BankingSystem.repository.AccountRepo;
import com.training.BankingSystem.repository.AtmRepo;
import com.training.BankingSystem.repository.BankRepo;
import com.training.BankingSystem.repository.CustomerRepo;
/*
 * Implementation of all account service class
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepo accountRepo;

	@Autowired
	BankRepo bankRepo;
	@Autowired
	CustomerRepo custRepo;
	@Autowired
	AtmRepo atmRepo;
	@Autowired
	TransactionService transervice;
	@Autowired
	BankDenmServiceImpl bankDenmService;
/*
 * (non-Javadoc)
 * @see com.training.BankingSystem.services.AccountService#createAccount(com.training.BankingSystem.model.Account)
 */
	@Override
	public Account createAccount(final Account account) {
		final Integer customerId = account.getCustomerId();
		final Integer bankId = account.getBankId();
		final Optional<Bank> bank1 = bankRepo.findByBankId(bankId);
		final Optional<Customer> customer1 = custRepo.findByCustomerId(customerId);
		if (bank1.isPresent() && customer1.isPresent()) {
			if (bank1.get().getBankId() == customer1.get().getBankId()) {
				final Account account1 = accountRepo.save(account);
				Bank savedBank=bank1.get();
				BigDecimal bankAmmount=savedBank.getAmount().add(account.getAmmount());
				savedBank.setAmount(bankAmmount);
				bankRepo.save(savedBank);
				return account1;
			} else {
				throw new MyException("Bank id Does not matches with customers bank id");
			}
		} else {
			throw new MyException("bank or customer dose not match");
		}

	}
/*
 * (non-Javadoc)
 * @see com.training.BankingSystem.services.AccountService#getAccountDetails(java.lang.Integer)
 */
	@Override
	public Account getAccountDetails(final Integer accountId) {

		final Optional<Account> account1 = accountRepo.findById(accountId);
		if (account1.isPresent()) {
			return account1.get();
		} else {
			throw new MyException("Account with this id is not present");
		}
	}
/*
 * (non-Javadoc)
 * @see com.training.BankingSystem.services.AccountService#withdrawMoney(java.math.BigDecimal, java.lang.Integer, java.lang.String, java.lang.Integer)
 */
	@Override
	@Transactional
	public void withdrawMoney(final BigDecimal withdrawl, final Integer accountId, final String select, final Integer atmId,final Integer customerId) {
		final Optional<Account> account1 = accountRepo.findById(accountId);
		
		if (account1.isPresent()) {
			final Account acnt1 = account1.get();
			final Integer bankId = acnt1.getBankId();
			final Integer customerId1 = acnt1.getCustomerId();
			if(customerId==customerId1)
			{
			if (select.equals("bank"))  {
				final Optional<Bank> opBank1 = bankRepo.findByBankId(bankId);

				if (opBank1.isPresent()) {
					final Bank bank1 = opBank1.get();
					System.out.println(bank1.getAmount());

					if (bank1.getAmount().intValue() > withdrawl.intValue()) {
						final BigDecimal accountAmmount = acnt1.getAmmount().subtract(withdrawl);
						acnt1.setAmmount(accountAmmount);
						accountRepo.save(acnt1);
						final BigDecimal bankAmmount = bank1.getAmount().subtract(withdrawl);
						bank1.setAmount(bankAmmount);
						bankRepo.save(bank1);
						//transervice.createTransaction(acnt1, "Debit");
						//bankDenmService.withdrawDenm(withdrawl, bankId);
					} else {
						throw new MyException("you are trying to withdraw invalid ammount");
					}
				} else {
					throw new MyException("bankId is not associted with this account");
				}

			} else if (select.equals("ATM")) {
				final Optional<ATM> atm1 = atmRepo.findById(atmId);

				if (atm1.isPresent()) {

					final ATM atm2 = atm1.get();

					if (withdrawl.intValue() < acnt1.getAmmount().intValue()) {
						final BigDecimal atmMoney = atm2.getAmmount().subtract(withdrawl);
						atm2.setAmmount(atmMoney);
						atmRepo.save(atm2);

						final BigDecimal accountMoney = acnt1.getAmmount().subtract(withdrawl);
						acnt1.setAmmount(accountMoney);
						accountRepo.save(acnt1);
						//transervice.createTransaction(acnt1, "Debit");
						

					} else {
						throw new MyException("Requested money is too large");
					}
				}
				else {
					throw new MyException("Atm with this Id is not presentor atm is not mapped with this account");
				}

				
			}
		
	else

	{
		throw new MyException("type must be bank or atm");
	}
		}else
		{
			throw new MyException("Account is not mapped with this customer");
			}
		}
	else
	{
		throw new MyException("Invalid account Id");
	}
	}

	@Override
	@Transactional
	public Account depositMoney(final BigDecimal deposit, final Integer accountId) {
		
		final Optional<Account> account2 = accountRepo.findById(accountId);
		if (account2.isPresent()) {
			final Account acnt2 = account2.get();
			final Integer bankId = acnt2.getBankId();
			final Optional<Bank> opBank2 = bankRepo.findByBankId(bankId);
			if (opBank2.isPresent()) {
				final Bank bank2 = opBank2.get();

				final BigDecimal accountAmmount = acnt2.getAmmount().add(deposit);
				acnt2.setAmmount(accountAmmount);
				accountRepo.save(acnt2);
				final BigDecimal bankAmmount = bank2.getAmount().add(deposit);
				bank2.setAmount(bankAmmount);
				bankRepo.save(bank2);
				//transervice.createTransaction(acnt2, "Credit");
				System.out.println("inside                  ");
				//bankDenmService.depositDemn(deposit, bankId);
			System.out.println("outside                   ");	
				return acnt2;

			} else {
				throw new MyException("bankId is not associted with this account");
			}

		} else {
			throw new MyException("Invalid account Id");
		}
	}

}
