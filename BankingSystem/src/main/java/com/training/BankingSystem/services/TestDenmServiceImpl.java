package com.training.BankingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.RefMoney;
import com.training.BankingSystem.model.TestDenomination;
import com.training.BankingSystem.repository.TestDenmRepo;
@Service
public class TestDenmServiceImpl implements TestDenmService {

	@Autowired
	TestDenmRepo refMoneyRepog;
	@Override
	public void addDenomination(List<Integer> denomination) {
		
		for(Integer value:denomination) {
			
		if(!refMoneyRepog.findById(value).isPresent())
		{
			TestDenomination testval=new TestDenomination(value);
			refMoneyRepog.save(testval);
		}
			
		}
		
		
	}

	
	
}
