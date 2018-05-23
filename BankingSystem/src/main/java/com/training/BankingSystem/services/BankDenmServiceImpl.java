package com.training.BankingSystem.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.BankDenm;
import com.training.BankingSystem.model.RefMoney;
import com.training.BankingSystem.repository.BankDenoRepo;

@Service
public class BankDenmServiceImpl implements BankDenmService {

	@Autowired
	BankDenoRepo bankDenoRepo;
	@Autowired
	RefMoneyService refMoneyService;
	
	
	
	@Override
	public void depositDemn(final BigDecimal ammount, final Integer bankId) {
	
		final List<RefMoney> list=refMoneyService.listOfDenomination();
		
		Integer ammountInInt = ammount.intValue();
	
		if (ammountInInt > 0) {

			while (ammountInInt != 0) {
				final Integer valueOfDenmPos = 0 + (int) (Math.random() * 4);
				RefMoney refMoney=list.get(valueOfDenmPos);
				final Integer  valueOfDenm= refMoney.getDenomination();
				if (ammountInInt >= valueOfDenm) {
						final Integer noOfDenm = ammountInInt / valueOfDenm;
						ammountInInt = ammountInInt % valueOfDenm;
	
						Optional<BankDenm> getDenm = bankDenoRepo.findById(valueOfDenm);
						BankDenm bankDenm = getDenm.get();
				
						
						final Integer noOfDenmDeposit=bankDenm.getNoOfDenomination()+noOfDenm;
					
						bankDenm.setNoOfDenomination(noOfDenmDeposit);
					
						bankDenoRepo.save(bankDenm);

					

				} 

			}

		} else {
			throw new MyException(" Amount can not be negative value ");
		}
	}

	@Override
	public void withdrawDenm(BigDecimal ammount, Integer bankId) {
		final List<Integer> DemValues=Arrays.asList(2000,500,100,10);
		Integer ammountInInt = ammount.intValue();
	
		if (ammountInInt > 0) {

			while (ammountInInt != 0) {
				final Integer valueOfDenmPos = 0 + (int) (Math.random() * 4);

				final Integer  valueOfDenm= DemValues.get(valueOfDenmPos);

				Optional<BankDenm> getDenm = bankDenoRepo.findById(valueOfDenm);
				BankDenm bankDenm = getDenm.get();
				final Integer noOfDenm = ammountInInt / valueOfDenm;
				if(noOfDenm<bankDenm.getNoOfDenomination() && ammountInInt >= valueOfDenm)
						{
						ammountInInt = ammountInInt % valueOfDenm;
						final Integer noOfDenmDeposit=bankDenm.getNoOfDenomination()-noOfDenm;
						bankDenm.setNoOfDenomination(noOfDenmDeposit);
						bankDenoRepo.save(bankDenm);
						}
				}
		} else {
			throw new MyException(" Amount can not be negative value ");
		}
	}
	@Override
	public void createBankDenm(BankDenm bankDenm) {

		bankDenm.setNoOfDenomination(0);
		bankDenoRepo.save(bankDenm);

		
	}

}
