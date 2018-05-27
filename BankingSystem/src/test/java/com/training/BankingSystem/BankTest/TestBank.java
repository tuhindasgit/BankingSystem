package com.training.BankingSystem.BankTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.repository.BankRepo;
import com.training.BankingSystem.services.BankServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestBank {
	

	
	@Mock
	private BankRepo bankRepo;
	
	
	
	@InjectMocks
	private BankServiceImpl bankserviceimpl;
	
	@Test
	public void TestBank()
	{
		final Bank bank=new Bank(new BigDecimal(102));
		when(bankRepo.save(Mockito.<Bank>any())).thenReturn(bank);
		
		assertEquals(bankserviceimpl.createBank(bank).getAmount(),new BigDecimal(102));
	}
	
	@Test(expected=MyException.class)
	public void TestBankF() {
		final Bank bank=new Bank(new BigDecimal(-102));
		when(bankserviceimpl.createBank(bank)).thenThrow(new MyException("invalid input"));
		
	}
	

}
