package com.training.BankingSystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.repository.BankRepo;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankRepo bankRepo;

	@Override
	public Bank createBank(Bank bank) {

		if (bank.getAmmount().intValue() < 0) {
			throw new MyException("invalid input,provide valid ammount");
		} else {
			Bank bank1 = bankRepo.save(bank);
			return bank1;
		}
	}

	@Override
	public Bank getBankDetails(Integer bankId) {
		
		Optional<Bank> bank = bankRepo.findById(bankId);
		if(bank.isPresent())
		{
		bankRepo.getOne(bankId);
		Bank bank2 = bank.get();
		return bank2;
		}
		else
		{
			throw new MyException("Id is not present");
		}
	}

}
