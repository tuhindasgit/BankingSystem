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

	@RequestMapping(value = "/addaccount", method = RequestMethod.POST)
	public ResponseEntity<?> addAccount(@RequestBody Account account) {
		try {
			Account account1 = acountservice.createAccount(account);
			return new ResponseEntity<Account>(account1, HttpStatus.CREATED);
		} catch (MyException e) {
			return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/viewaccount/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<?> viewAccount(@PathVariable Integer accountId) {
		try {
			Account account1 = acountservice.getAccountDetails(accountId);
			return new ResponseEntity<Account>(account1, HttpStatus.CREATED);
		} catch (MyException e) {
			return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/withdrawammount/{withdraw}/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<?> withdrawFromBank(@PathVariable BigDecimal withdraw, @PathVariable Integer accountId) {
		try {
			Account account2 = acountservice.withdrawMoney(withdraw, accountId);
			return new ResponseEntity<Account>(account2, HttpStatus.CREATED);
		} catch (MyException e) {
			return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/depositammount/{deposit}/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<?> depositFromBank(@PathVariable BigDecimal deposit, @PathVariable Integer accountId) {
		try {
			Account account3 = acountservice.depositMoney(deposit, accountId);
			return new ResponseEntity<Account>(account3, HttpStatus.CREATED);
		} catch (MyException e) {
			return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
		}

	}

}
