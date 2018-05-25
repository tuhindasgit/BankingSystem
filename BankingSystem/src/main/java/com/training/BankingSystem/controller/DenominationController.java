package com.training.BankingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.BankingSystem.helper.RequestDenm;
import com.training.BankingSystem.services.BankDenmService;
import com.training.BankingSystem.services.DenmService;

@RestController
@RequestMapping(value="/denomination")
public class DenominationController {

	@Autowired
	BankDenmService bankdenm;
	@Autowired
	DenmService denm;
	/*@Autowired
	AtmDenmService atmDenm;*/
	
	@PostMapping
	public ResponseEntity<?> addDenomination1(@RequestBody final 
			RequestDenm request) {
		
		denm.addDenomination(request.getDenomination());
		
		bankdenm.createBankDenomination(request.getDenomination(),request.getBankId());
		//atmDenm.createAtmDenm(request.getDenomination(),request.getAtmId());
		return new ResponseEntity<String>("created", HttpStatus.CREATED);
}
}
