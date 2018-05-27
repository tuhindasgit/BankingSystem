package com.training.BankingSystem.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Account;
import com.training.BankingSystem.services.AccountServiceImpl;

@RestController

public class AccountController {
	@Autowired
	AccountServiceImpl acountservice;	
/*
 * Request-response mapping for adding a account
 */
	@RequestMapping(value = "/addaccount", method = RequestMethod.POST)
	public ResponseEntity<?> addAccount(@RequestBody final Account account) {
		try {
			final Account accountRes = acountservice.createAccount(account);
			return new ResponseEntity<Account>(accountRes, HttpStatus.CREATED);
		} catch (MyException e) {
			return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
		}

	}
/*
 * To view a account
 */
	@RequestMapping(value = "/viewaccount/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<?> viewAccount(@PathVariable final Integer accountId) {
		try {
			final Account accountRes = acountservice.getAccountDetails(accountId);
			return new ResponseEntity<Account>(accountRes, HttpStatus.CREATED);
		} catch (MyException e) {
			return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
		}

	}
/*
 * Rest end point for withdraw function
 * select=ATM or bank
 */
	@RequestMapping(value = "/withdrawammount/{withdraw}/{accountId}/{select}/{atmID}/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<?> withdrawFromBank(@PathVariable final BigDecimal withdraw, @PathVariable final Integer accountId,
			@PathVariable final String select, @PathVariable final Integer atmID,@PathVariable final Integer customerId) {
		try {
			 acountservice.withdrawMoney(withdraw, accountId,select,atmID,customerId);
			return new ResponseEntity<String>("Money withdrawn",HttpStatus.CREATED);
		} catch (MyException e) {
			return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
		}

	}
/*
 * Rest end point for deposit for deposit amount
 */
	@RequestMapping(value = "/depositammount/{deposit}/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<?> depositFromBank(@PathVariable final BigDecimal deposit, @PathVariable final Integer accountId) {
		try {
			final Account accountRes = acountservice.depositMoney(deposit, accountId);
			return new ResponseEntity<Account>(accountRes, HttpStatus.CREATED);
		} catch (MyException e) {
			return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
		}

	}
	

}
