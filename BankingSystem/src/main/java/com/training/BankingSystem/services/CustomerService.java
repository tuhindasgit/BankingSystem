package com.training.BankingSystem.services;

import java.util.List;

import com.training.BankingSystem.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer);
	public List<Customer> getCustomerDetails(Integer customerId);
}
