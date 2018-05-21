package com.training.BankingSystem.services;

import java.util.Optional;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.repository.BankRepo;
/*
 * Service class for bank service Implementation
 */
@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankRepo bankRepo;
	

/*
 * (non-Javadoc)
 * @see com.training.BankingSystem.services.BankService#createBank(com.training.BankingSystem.model.Bank)
 */
	@Override
	public Bank createBank(final Bank bank) {

		if (bank.getAmount().intValue()<0) {
			throw new MyException("invalid input,provide valid ammount");
		} else {
			return bankRepo.save(bank);
		}
	}

	@Override
	public Bank getBankDetails(final Integer bankId) {
		
		final Optional<Bank> bank = bankRepo.findById(bankId);
		if(bank.isPresent())
		{
		
		return bank.get();
		}
		else
		{
			throw new MyException("Id is not present");
		}
	}

}
