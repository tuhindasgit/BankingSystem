package com.training.BankingSystem.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.ATM;
import com.training.BankingSystem.services.AtmServiceImpl;

@RestController
public class AtmController {

	@Autowired
	AtmServiceImpl atmservice;
	
	@RequestMapping(value = "/addatm", method = RequestMethod.POST)
	public ResponseEntity<?> addAtm(@RequestBody ATM atm)
	{
		try
		{
			ATM atm1=atmservice.createBank(atm);
			return new ResponseEntity<ATM>(atm1,HttpStatus.CREATED);
		}
		catch(MyException e)
		{
			return new ResponseEntity<String>(e.toString(),HttpStatus.BAD_REQUEST);
		}
	}
		
		@RequestMapping(value = "/depositfrombank/{Deposit}/{atmId}", method = RequestMethod.GET)
		public ResponseEntity<?> depositFromBank(@PathVariable BigDecimal Deposit,
										@PathVariable Integer atmId
											)
		{	
			try
			{
				ATM atm1=atmservice.addMoneyFromBank(Deposit, atmId);
				return new ResponseEntity<ATM>(atm1,HttpStatus.CREATED);
			}
			catch(MyException e)
			{
				return new ResponseEntity<String>(e.toString(),HttpStatus.BAD_REQUEST);
			}
		
	}
		
		@RequestMapping(value = "/withdrawfromatm/{withdrawl}/{atmId}/{accountId}", method = RequestMethod.GET)
		public ResponseEntity<?> depositFromBank(@PathVariable BigDecimal withdrawl,@PathVariable Integer atmId,
										@PathVariable Integer accountId
											)
		{	
			try
			{
				ATM atm1=atmservice.withdrawAmmount(withdrawl, atmId, accountId);
				return new ResponseEntity<ATM>(atm1,HttpStatus.CREATED);
			}
			catch(MyException e)
			{
				return new ResponseEntity<String>(e.toString(),HttpStatus.BAD_REQUEST);
			}
		
	}
}
