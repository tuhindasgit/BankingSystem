package com.training.BankingSystem.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.model.RefAtmDenm;
import com.training.BankingSystem.repository.AtmDenmRepo;
@Service
public class AtmDnmServiceImpl implements AtmDenmService {

	@Autowired
	AtmDenmRepo atmDenmRepo;
	@Override
	public void CreateAtmDenm(RefAtmDenm refAtmDenm) {
		refAtmDenm.setNoOfDenomination(0);
		atmDenmRepo.save(refAtmDenm);
	}
	@Override
	public void depositFromBankDenm(BigDecimal ammount, Integer atmId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void withdrawDenm(BigDecimal ammount, Integer atmId) {
		// TODO Auto-generated method stub
		
	}

}
