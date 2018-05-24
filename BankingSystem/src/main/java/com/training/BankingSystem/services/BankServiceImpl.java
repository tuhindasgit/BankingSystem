package com.training.BankingSystem.services;

import java.util.Optional;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.training.bankingsystem.exception.MyException;
import com.training.bankingsystem.model.Bank;
import com.training.bankingsystem.repository.BankRepo;
/*
 * Service class for bank service Implementation
 */
@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankRepo bankRepo;
/*
 * creating new bank 
 * sending bank object
 */
	@Override
	public Bank createBank(final Bank bank) {

		if (bank.getAmount().intValue()<0) {
			throw new MyException("invalid input,provide valid ammount");
		} else {
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
		final Optional<Bank> bank = bankRepo.findById(bankId);
		if(bank.isPresent())
		{
				return bank.get();
		}
		else
		{
			throw new MyException("noDataFound");
		}
	}
}
