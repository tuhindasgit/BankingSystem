package com.training.BankingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.BankingSystem.model.RefMoney;
import com.training.BankingSystem.services.RefMoneyService;

@RestController
@RequestMapping(value="/refMoney")
public class RefMoneyController {

	@Autowired
	RefMoneyService refMoneyService;
	
	@PostMapping(value="/{denomination}")
	public ResponseEntity<?> addRefMoney(@PathVariable Integer denomination) {
		
		refMoneyService.addDenomination(denomination);
			return new ResponseEntity<String>("created", HttpStatus.CREATED);
}
	@GetMapping
public ResponseEntity<?> retriveRefMoney() {
		
		List<RefMoney> refMoney= refMoneyService.listOfDenomination();
			return new ResponseEntity<List>(refMoney, HttpStatus.CREATED);
}
}

