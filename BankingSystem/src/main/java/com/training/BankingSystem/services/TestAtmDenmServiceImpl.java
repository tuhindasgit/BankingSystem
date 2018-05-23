package com.training.BankingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.model.TestAtmDenominatio;
import com.training.BankingSystem.model.TestBankDenomination;
import com.training.BankingSystem.repository.TestAtmDenmRepo;
import com.training.BankingSystem.repository.TestBenkDenmRepo;
@Service
public class TestAtmDenmServiceImpl implements TestAtmDenmService {
	@Autowired
	TestAtmDenmRepo testAtmDenm;
	@Override
	public void createAtmDenm(List<Integer> denomination, Integer atmId) {
		
		for(Integer list:denomination)
		{
			TestAtmDenominatio atmdenm=new TestAtmDenominatio(list,0,atmId);
			testAtmDenm.save(atmdenm);
			
		}
		
	}
}
