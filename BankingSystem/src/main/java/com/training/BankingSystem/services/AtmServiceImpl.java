package com.training.BankingSystem.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.ATM;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.repository.AtmRepo;

/**
 * @author trainee
 *
 */

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	AtmRepo atmRepo;

	@Autowired
	BankService bankService;
	@Autowired
	AccountService accountService;

	/**
	 * creating a Atm ,Here we are matching that related bank is present or not
	 */
	@Override
	public ATM createBank(final ATM atm) throws MyException{
		
		final Integer id=atm.getBankId();
		final Optional<Bank> bankOption=bankService.findById(id);
		if(bankOption.isPresent())
		{
		return atmRepo.save(atm);
		
	}
		else
		{
			throw new MyException("provide valid bank id ...bank id not present");
			}
		}
	
	/**
	 * takes the money or amount that will transfer from bank to a specific atm
	 * atm id provided to see exact Atm,where money will be deposited
	 */
	@Override
	public ATM addMoneyFromBank(final BigDecimal deposit, final Integer atmId) {
	
		final Optional<ATM> atm1=atmRepo.findById(atmId);
		if(atm1.isPresent())
		{
			final Integer id=atm1.get().getBankId();
			final Optional<Bank> bank1=bankService.findById(id);
			final Bank bank2=bank1.get();
				if(deposit.intValue() < bank2.getAmount().intValue())
				{
					atm1.get().setAmmount(atm1.get().getAmmount().add(deposit));
					atmRepo.save(atm1.get());
					bank2.setAmount(bank2.getAmount().subtract(deposit));
					bankService.createBank(bank2);
					return atm1.get();
				}
				else
				{
					throw new MyException("ATM has less amount");
				}
			}
		
		else
		{
			throw new MyException("Atm with this Id is not present");
		}
		
	}
}
	
	

	

