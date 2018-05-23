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
import com.training.BankingSystem.model.TestRequestDenm;
import com.training.BankingSystem.services.BankDenmServiceImpl;
import com.training.BankingSystem.services.TestAtmDenmService;
import com.training.BankingSystem.services.TestBankDenmService;
import com.training.BankingSystem.services.TestDenmService;

@RestController
@RequestMapping(value="/denomination")
public class DenominationController {

	@Autowired
	TestBankDenmService bankdenm;
	@Autowired
	TestDenmService denm;
	@Autowired
	TestAtmDenmService atmDenm;
	
	@PostMapping
	public ResponseEntity<?> addDenomination1(@RequestBody final TestRequestDenm request) {
		
		denm.addDenomination(request.getDenomination());
		
		bankdenm.createBankDenm(request.getDenomination(),request.getBankId());
		atmDenm.createAtmDenm(request.getDenomination(),request.getAtmId());
		return new ResponseEntity<String>("created", HttpStatus.CREATED);
}
}
