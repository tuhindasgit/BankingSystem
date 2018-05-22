package com.training.BankingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.services.BankServiceImpl;
/*
 * Rest Controller for bank services
 */
@RestController
@RequestMapping(value="/bank")
public class BankController {

	@Autowired
	BankServiceImpl bankService;
/*
 * Rest end point for adding a bank
 */
	@PostMapping
	public ResponseEntity<?> addbank(@RequestBody final Bank bank) {
		try {
			final Bank bank1 = bankService.createBank(bank);
			return new ResponseEntity<Bank>(bank1, HttpStatus.CREATED);
		} catch (MyException e) {

			return new ResponseEntity<String>(e.toString(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
/*
 * Rest end point for viewing a bank
 */
	@GetMapping(value ="/{bankId}")
	public ResponseEntity<?> viewbank(@PathVariable("bankId") final Integer bankId) {
		try {
			final Bank bank2 = bankService.getBankDetails(bankId);

			return new ResponseEntity<Bank>(bank2, HttpStatus.OK);
		} catch (MyException e) {

			return new ResponseEntity<String>(e.toString(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
