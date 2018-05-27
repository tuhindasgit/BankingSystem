package com.training.BankingSystem.BankTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.training.BankingSystem.model.Account;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.Customer;
import com.training.BankingSystem.repository.AccountRepo;
import com.training.BankingSystem.repository.BankRepo;
import com.training.BankingSystem.repository.CustomerRepo;
import com.training.BankingSystem.services.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestAccount {

	@InjectMocks
	AccountServiceImpl accountService;
	@Mock
	BankRepo bankRepo;
	@Mock
	CustomerRepo customerRepo;
	@Mock
	AccountRepo accountRepo;
	
	@Test
	public void TestCreateAccount()
	{
		final Bank bank=new Bank(1,new BigDecimal(100));
		final Optional<Bank> demoBank=Optional.of(bank);
		when(bankRepo.findById(1)).thenReturn(demoBank);
		final Customer customer=new Customer("tuhin",103203,1);
		final Optional<Customer> demoCustomer=Optional.of(customer);
		when(customerRepo.findById(1)).thenReturn(demoCustomer);
		final Account account=new Account(1,1,new BigDecimal(100));
		when(accountRepo.save(Mockito.<Account>any())).thenReturn(account);
		assertEquals(account.getBankId(),accountService.createAccount(account).getBankId());
		
	}
	
	@Test
	public void TestDepositAccount()
	{
		final Account account=new Account(1,1,new BigDecimal(100));
		final Optional<Account> demoAccount=Optional.of(account);
		when(accountRepo.findById(1)).thenReturn(demoAccount);
		
		final Bank bank=new Bank(1,new BigDecimal(100));
		final Optional<Bank> demoBank=Optional.of(bank);
		when(bankRepo.findById(1)).thenReturn(demoBank);
		
		final Account accountReturned=new Account(1,1,new BigDecimal(200));
		when(accountRepo.save(Mockito.<Account>any())).thenReturn(accountReturned);
		
		assertEquals(accountReturned,accountService.depositMoney(new BigDecimal(100),1));
	}
	
	
}
