package com.training.BankingSystem.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.BankingSystem.model.RefAtmDenm;
import com.training.BankingSystem.repository.AtmDenmRepo;

public class AtmDnmServiceImpl implements AtmDenmService {

	@Autowired
	AtmDenmRepo atmDenmRepo;
	@Override
	public void CreateAtmDenm(RefAtmDenm refAtmDenm) {
		refAtmDenm.setNoOfDenomination(0);
		atmDenmRepo.save(refAtmDenm);
	}

}
