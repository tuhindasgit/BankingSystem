package com.training.BankingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.Customer;
import com.training.BankingSystem.services.BankServiceImpl;

@RestController
public class BankController {

	@Autowired
	BankServiceImpl bankService;

	@RequestMapping(value = "/addbank", method = RequestMethod.POST)
	public ResponseEntity<?> addbank(@RequestBody Bank bank) {
		try {
			Bank bank1 = bankService.createBank(bank);
			return new ResponseEntity<Bank>(bank, HttpStatus.CREATED);
		} catch (MyException e) {

			return new ResponseEntity<String>(e.toString(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@RequestMapping(value = "/viewbank/{bankId}", method = RequestMethod.GET)
	public ResponseEntity<?> viewbank(@PathVariable("bankId") Integer bankId) {
		try {
			Bank bank2 = bankService.getBankDetails(bankId);

			return new ResponseEntity<Bank>(bank2, HttpStatus.OK);
		} catch (MyException e) {

			return new ResponseEntity<String>(e.toString(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
