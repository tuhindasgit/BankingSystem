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
import com.training.BankingSystem.model.Customer;
import com.training.BankingSystem.services.CustomerServiceImpl;
/*
 * Rest Controller for Customer Service
 */
@RestController
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	CustomerServiceImpl custService;
/*
 * Rest end point for adding customer	
 */
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody final Customer customer) {
		try {
			final Customer customer1 = custService.createCustomer(customer);
			return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
		} catch (MyException e) {

			return new ResponseEntity<String>(e.toString(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	/*
	 * Rest end point for viewing customer
	 */
	@GetMapping(value = "/{customerId}")
	public ResponseEntity<?> viewCustomer(@PathVariable("customerId") final Integer customerId) {
		try {
			final Customer customer2 = custService.getCustomerDetails(customerId);

			return new ResponseEntity<Customer>(customer2, HttpStatus.OK);
		} catch (MyException e) {

			return new ResponseEntity<String>(e.toString(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
}
