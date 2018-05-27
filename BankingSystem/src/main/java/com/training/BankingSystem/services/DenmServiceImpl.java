package com.training.BankingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.model.Denomination;
import com.training.BankingSystem.repository.DenmRepo;

/**
 * @authortuhin
 *
 */
@Service
public class DenmServiceImpl implements DenmService {

	@Autowired
	DenmRepo denmRepo;
	
	private Denomination testval;
	/**
	 * method that will add denomination of whole banking system
	 */
	@Override
	public void addDenomination(final List<Integer> denomination) {
		
		for(Integer value:denomination) {
		if(!denmRepo.findById(value).isPresent())
		{
			testval=new Denomination(value);
			denmRepo.save(testval);
		}
			}
			}
	@Override
	public List<Denomination> denominationList() {
		
		return denmRepo.findAll();
	}

	}
