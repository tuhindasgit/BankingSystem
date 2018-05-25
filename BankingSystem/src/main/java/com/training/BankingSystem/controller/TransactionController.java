package com.training.BankingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Transaction;
import com.training.BankingSystem.services.TransactionService;
/*
 * Rest Controller for transaction Service
 */
@RestController
public class TransactionController {

	@Autowired
	TransactionService transervice;
	/*
	 * Rest End for showing Transaction
	 */
	@RequestMapping(value="/showtransaction",method=RequestMethod.GET)
	public ResponseEntity<?> showTransaction()
	{
		try
		{
			final List<Transaction> transList=transervice.generateTransactionReport();
			return new ResponseEntity<List>(transList,HttpStatus.OK);
		}catch(MyException e)
		{
			return new ResponseEntity<String>(e.toString(),HttpStatus.NO_CONTENT);
		}
	}
}
