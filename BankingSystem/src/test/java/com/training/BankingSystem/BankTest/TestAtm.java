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
import com.training.BankingSystem.model.ATM;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.repository.AtmRepo;
import com.training.BankingSystem.repository.BankRepo;
import com.training.BankingSystem.repository.CustomerRepo;
import com.training.BankingSystem.services.AtmServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestAtm {

	@Mock
	private CustomerRepo custmerRepo;
	@Mock
	BankRepo bankRepo;
	@Mock
	AtmRepo atmRepo;
	@InjectMocks
	AtmServiceImpl atmService;
	
	
	
	@Test
	public void TestCreateAtm()
	{
		ATM atm=new ATM(new BigDecimal(100), 1);
		Bank bank=new Bank(1,new BigDecimal(100));
		Optional<Bank> demoBank=Optional.of(bank);
		when(bankRepo.findById(1)).thenReturn(demoBank);
		when(atmRepo.save(Mockito.<ATM>any())).thenReturn(atm);
		assertEquals(new BigDecimal(100),atmService.createBank(atm).getAmmount());
	}
	
	@Test(expected=MyException.class)
	public void TestCreateAtmF() {
		final ATM atm=new ATM(new BigDecimal(100), 1);
		final Bank bank=new Bank(new BigDecimal(-102));
		when(atmService.createBank(atm)).thenThrow(new MyException("invalid input"));
		
	}
	
	@Test
	public void TestAddMoney() {
		final ATM atm=new ATM(new BigDecimal(100), 1);
		final Optional<ATM> demoAtm=Optional.of(atm);
		when(atmRepo.findById(1)).thenReturn(demoAtm);
		final Bank bank=new Bank(1,new BigDecimal(100));
		final Optional<Bank> demoBank=Optional.of(bank);
		when(bankRepo.findById(1)).thenReturn(demoBank);
		final ATM returnedAtm=new ATM(new BigDecimal(140), 1);
		final Optional<ATM> returnedDemoAtm=Optional.of(returnedAtm);
		when(atmRepo.save(Mockito.<ATM>any())).thenReturn(returnedDemoAtm.get());
		assertEquals(returnedDemoAtm.get(),atmService.addMoneyFromBank(new BigDecimal(40),1));
	}
	@Test(expected=MyException.class)
	public void TestAddMoneyN() {
		final ATM atm=new ATM(new BigDecimal(100), 1);
		final Optional<ATM> demoAtm=Optional.of(atm);
		when(atmRepo.findById(1)).thenReturn(demoAtm);
		final Bank bank=new Bank(1,new BigDecimal(100));
		final Optional<Bank> demoBank=Optional.of(bank);
		when(bankRepo.findById(1)).thenReturn(demoBank);
		//ATM returnedAtm=new ATM(new BigDecimal(140), 1);
		//Optional<ATM> returnedDemoAtm=Optional.of(returnedAtm);
		//when(atmRepo.save(Mockito.<ATM>any())).thenReturn(returnedDemoAtm.get());
		when(atmService.addMoneyFromBank(new BigDecimal(200),1)).thenThrow(new MyException("invalid input"));
		//assertEquals(returnedDemoAtm.get(),atmService.addMoneyFromBank(new BigDecimal(200),1));
	}
}
