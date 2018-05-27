package com.training.BankingSystem.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.BankDenomination;
import com.training.BankingSystem.model.Denomination;
import com.training.BankingSystem.repository.BankDenmRepo;
@Service
public class BankDenmServiceImpl implements BankDenmService {

	@Autowired
	BankDenmRepo bankDenmRepo;
	@Autowired
	DenmService denmService;
	@Override
	public void deptDenmInBank(BigDecimal amount, Integer bankId) {
		
		final List<Denomination> list=denmService.denominationList();
		
		Integer ammountInInt = amount.intValue();
	
		if (ammountInInt > 0) {

			while (ammountInInt != 0) {
				
				final Integer valueOfDenmPos = 0 + (int) (Math.random() * 4);
				
				Denomination denomination=list.get(valueOfDenmPos);
				final Integer  valueOfDenm= denomination.getDenomination();
				
				if (ammountInInt >= valueOfDenm) {
						final Integer noOfDenm = ammountInInt / valueOfDenm;
						ammountInInt = ammountInInt % valueOfDenm;
	
						Optional<BankDenomination> getDenm = bankDenmRepo.findById(valueOfDenm);
						BankDenomination bankDenm = getDenm.get();
				
						
						final Integer noOfDenmDeposit=bankDenm.getNoOfDenomination()+noOfDenm;
					
						bankDenm.setNoOfDenomination(noOfDenmDeposit);
					
						bankDenmRepo.save(bankDenm);

					

				} 

			}

		} else {
			throw new MyException(" Amount can not be negative value ");
		}
		
	}

	@Override
	public void wdlDenmFrmBank(BigDecimal amount, Integer bankId) {
		
		final List<Denomination> demValues=denmService.denominationList();
				
		Integer ammountInInt = amount.intValue();
	
		if (ammountInInt > 0) {

			while (ammountInInt != 0) {
				final Integer valueOfDenmPos = 0 + (int) (Math.random() * 4);

				final Denomination  valueOfDenm= demValues.get(valueOfDenmPos);
				final Integer value=valueOfDenm.getDenomination();

				Optional<BankDenomination> getDenm = bankDenmRepo.findById(value);
				BankDenomination bankDenm = getDenm.get();
				final Integer noOfDenm = ammountInInt / value;
				if(noOfDenm<bankDenm.getNoOfDenomination() && ammountInInt >= value)
						{
						ammountInInt = ammountInInt % value;
						final Integer noOfDenmDeposit=bankDenm.getNoOfDenomination()-noOfDenm;
						bankDenm.setNoOfDenomination(noOfDenmDeposit);
						bankDenmRepo.save(bankDenm);
						}
				}
		} else {
			throw new MyException(" Amount can not be negative value ");
		}
		
	}

	@Override
	public void createBankDenomination(List<Integer> denomination, Integer bankId) {
		
			for(Integer list:denomination)
					{
				BankDenomination bankDenm =new BankDenomination(list,0,bankId);
				bankDenmRepo.save(bankDenm);
						}
		}
		
	

}
