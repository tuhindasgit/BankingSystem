package com.training.BankingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bankingsystem.model.Denomination;
import com.training.bankingsystem.repository.DenmRepo;
@Service
public class DenmServiceImpl implements DenmService {

	@Autowired
	DenmRepo refMoneyRepog;
	@Override
	public void addDenomination(List<Integer> denomination) {
		
		for(Integer value:denomination) {
			
		if(!refMoneyRepog.findById(value).isPresent())
		{
			Denomination testval=new Denomination(value);
			refMoneyRepog.save(testval);
		}
			
		}
		
		
	}

	
	
}
