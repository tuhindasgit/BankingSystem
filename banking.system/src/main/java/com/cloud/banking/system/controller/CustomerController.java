package com.cloud.banking.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.banking.system.exception.BankException;
import com.cloud.banking.system.model.Customer;
import com.cloud.banking.system.service.CustomerService;

/**
 * @author tuhindas customer service rest end points
 *
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/**
	 * Rest end point for adding customer
	 */
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody final Customer customer) {
		try {
			final Customer customerRes = customerService.createCustomer(customer);
			return new ResponseEntity<Customer>(customerRes, HttpStatus.CREATED);
		} catch (BankException e) {

			return new ResponseEntity<String>(e.toString(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
