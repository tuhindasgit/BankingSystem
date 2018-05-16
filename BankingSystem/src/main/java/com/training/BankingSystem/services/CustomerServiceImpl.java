package com.training.BankingSystem.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.Customer;
import com.training.BankingSystem.repository.CustomerRepo;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo custRepo;
	
	@Override
	public Customer createCustomer(Customer customer) {
	
		Customer customer1=custRepo.save(customer);
		return customer1;
	}

	@Override
	public Customer getCustomerDetails(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
