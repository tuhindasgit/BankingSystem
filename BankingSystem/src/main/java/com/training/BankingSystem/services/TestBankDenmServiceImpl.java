package com.training.BankingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.model.TestBankDenomination;
import com.training.BankingSystem.repository.TestBenkDenmRepo;
@Service
public class TestBankDenmServiceImpl implements TestBankDenmService {

	@Autowired
	TestBenkDenmRepo testbankdeno;
	@Override
	public void createBankDenm(List<Integer> denomination, Integer bankId) {
		
		for(Integer list:denomination)
		{
			TestBankDenomination bankDenm=new TestBankDenomination(list,0,bankId);
			testbankdeno.save(bankDenm);
		}
		
	}

}
