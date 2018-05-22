package com.training.BankingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.RefMoney;
import com.training.BankingSystem.repository.RefMoneyRepo;

public class RefMoneyServiceImpl implements RefMoneyService{

	@Autowired
	RefMoneyRepo refMoneyRepo;
	@Override
	public String addDenomination(Integer newDenomination) {
		if(refMoneyRepo.findById(newDenomination).isPresent())
		{
			throw new MyException("Denomination already present");
		}
		else
		{
			RefMoney newRefDenomination=new RefMoney();
			newRefDenomination.setDenomination(newDenomination);
			refMoneyRepo.save(newRefDenomination);
			return "added";
		}
	}

	@Override
	public List<RefMoney> listOfDenomination() {
		return refMoneyRepo.findAll();
	}

}
