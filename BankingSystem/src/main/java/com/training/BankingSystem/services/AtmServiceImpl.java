package com.training.BankingSystem.services;

import java.math.BigDecimal;
import java.util.Optional;

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

/**
 * @author trainee
 *
 */

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	AtmRepo atmRepo;
	@Autowired
	BankRepo bankRepo;
	@Autowired
	AccountRepo accountRepo;
	
	/*
	 * (non-Javadoc)
	 * @see com.training.BankingSystem.services.AtmService#createBank(com.training.BankingSystem.model.ATM)
	 */
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
	
	/* (non-Javadoc)
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
					throw new MyException("Demoneitization,wait for few days");
				}
			}
		
		else
		{
			throw new MyException("Atm with this Id is not present");
		}
		
	}
	
	@Override
	public ATM withdrawAmmount(BigDecimal withdrawl, Integer atmId,Integer accountId) {
		Optional<ATM> atm1=atmRepo.findById(atmId);
		Optional<Account> account1=accountRepo.findById(accountId);
		if(atm1.isPresent() && account1.isPresent())
		{
			
			ATM atm2=atm1.get();
			Account account=account1.get();
				if(withdrawl.intValue() < account.getAmmount().intValue())
				{
					BigDecimal atmMoney=atm2.getAmmount().subtract(withdrawl);
					atm2.setAmmount(atmMoney);
					atmRepo.save(atm2);
				
					BigDecimal accountMoney=account.getAmmount().subtract(withdrawl);
					account.setAmmount(accountMoney);
					accountRepo.save(account);
					
					return atm2;
				}
				else
				{
					throw new MyException("awkat ki bahar");
				}
			}
		
		else
		{
			throw new MyException("Atm with this Id is not presentor atm is not mapped with this account");
		}
	}

	}

	

