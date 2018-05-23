//package com.training.BankingSystem.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.training.BankingSystem.model.BankDenm;
//import com.training.BankingSystem.model.RefAtmDenm;
//import com.training.BankingSystem.services.AtmDenmService;
//
//@RestController(value="/atmDenm")
//public class AtmDenominationController {
//
//	@Autowired
//	AtmDenmService atmDenmService;
//	
//	@PostMapping
//	public ResponseEntity<?> addAtmDenomination(@RequestBody final RefAtmDenm atmDenm) {
//		
//		atmDenmService.CreateAtmDenm(atmDenm);
//		return new ResponseEntity<String>("created", HttpStatus.CREATED);
//}
//}
