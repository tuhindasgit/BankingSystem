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

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.Customer;
import com.training.BankingSystem.repository.BankRepo;
import com.training.BankingSystem.repository.CustomerRepo;
import com.training.BankingSystem.services.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestCustomer {

	@Mock
	CustomerRepo custmerRepo;
	@Mock
	BankRepo bankRepo;
	@InjectMocks
	CustomerServiceImpl customerService;
	
	@Test
	public void TestCustomer()
	{
		Customer customer=new Customer("tuhin",103203,1);
		Bank bank=new Bank(1,new BigDecimal(100));
		Optional<Bank> demoBank=Optional.of(bank);
		when(bankRepo.findById(1)).thenReturn(demoBank);
		when(custmerRepo.save(Mockito.<Customer>any())).thenReturn(customer);
		assertEquals("tuhin",customerService.createCustomer(customer).getName());
	}
	
	@Test(expected=MyException.class)
	public void TestCustomerF() {
		Customer customer=new Customer("tuhin",103203,1);
		Bank bank=new Bank(1,new BigDecimal(100));
		Optional<Bank> demoBank=Optional.of(bank);
		when(customerService.createCustomer(customer)).thenThrow(new MyException("invalid input"));
		
	}
	
}
