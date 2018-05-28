package com.training.BankingSystem.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.repository.BankRepo;
/**
 * Service class for bank service Implementation
 */
@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankRepo bankRepo;
	private static final Logger log=LoggerFactory.getLogger(BankServiceImpl.class);
/**
 * creating new bank 
 * sending bank object
 */
	@Override
	public Bank createBank(final Bank bank) {

		if (bank.getAmount().intValue()<0) {
			throw new MyException("invalid input,provide valid ammount");
		} else {
			log.info("customer Created");
			return bankRepo.save(bank);
			
		}
	}
/*
 * Retrieve a specific BankDetails
 * @param bankId
 * @return Bank Object
  */
	@Override
	public Bank getBankDetails(final Integer bankId) {
		final Optional<Bank> bank = bankRepo.findByBankId(bankId);
		if(bank.isPresent())
		{
			log.info("customer Details:  " +bank.get());
				return bank.get();
		}
		else
		{
					throw new MyException("noDataFound");
		}
	}
	/**
	 * that will find the bank object present or not
	 */
	@Override
	public Optional<Bank> findById(Integer bankId) {
		
		return bankRepo.findByBankId(bankId);
	}
}
