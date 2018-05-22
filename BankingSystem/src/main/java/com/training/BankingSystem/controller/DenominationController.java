package com.training.BankingSystem.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.BankDenm;
import com.training.BankingSystem.services.BankDenmServiceImpl;

@RestController
@RequestMapping(value="/denomination")
public class DenominationController {

	@Autowired
	BankDenmServiceImpl bankDenmService;
	
	@PostMapping
	public ResponseEntity<?> addDenomination(@RequestBody final BankDenm bankDenm) {
		
			bankDenmService.createBankDenm(bankDenm);
			return new ResponseEntity<String>("created", HttpStatus.CREATED);
}
}
