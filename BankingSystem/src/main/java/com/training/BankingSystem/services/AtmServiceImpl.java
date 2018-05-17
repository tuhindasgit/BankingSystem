package com.training.BankingSystem.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.ATM;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.repository.AtmRepo;
import com.training.BankingSystem.repository.BankRepo;

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	AtmRepo atmRepo;
	@Autowired
	BankRepo bankRepo;
	@Override
	public ATM createBank(ATM atm) throws MyException{
		
		Integer id=atm.getBankId();
		Optional<Bank> bank1=bankRepo.findById(id);
		if(bank1.isPresent())
		{
		return atmRepo.save(atm);
		
	}
		else
		{
			throw new MyException("provide valid bank id ...bank id not present");
			}
		}
	/*
	 * (non-Javadoc)
	 * @see com.training.BankingSystem.services.AtmService#addMoneyFromBank(java.math.BigDecimal, java.lang.Integer)
	 */
	@Override
	public ATM addMoneyFromBank(BigDecimal deposit, Integer atmId) {
	
		Optional<ATM> atm1=atmRepo.findById(atmId);
		if(atm1.isPresent())
		{
			Integer id=atm1.get().getBankId();
			Optional<Bank> bank1=bankRepo.findById(id);
			Bank bank2=bank1.get();
				if(deposit.intValue() < bank2.getAmount().intValue())
				{
					atm1.get().setAmmount(atm1.get().getAmmount().add(deposit));
					atmRepo.save(atm1.get());
					bank2.setAmount(bank2.getAmount().subtract(deposit));
					bankRepo.save(bank2);
					return atm1.get();
				}
				else
				{
					throw new MyException("awkat ki bahar");
				}
			}
		
		else
		{
			throw new MyException("Atm with this Id is not present");
		}
		
	}

	}

	

