package com.training.BankingSystem.services;

import com.training.BankingSystem.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer);
	public Customer getCustomerDetails(Customer customer);
}
