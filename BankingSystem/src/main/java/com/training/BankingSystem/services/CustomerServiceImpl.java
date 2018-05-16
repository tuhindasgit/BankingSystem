package com.training.BankingSystem.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.BankingSystem.repository.CustomerRepo;

public class CustomerServiceImpl implements CustomerService  {

	@Autowired
	CustomerRepo customerRepo;
	


	

}
