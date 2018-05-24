package com.training.BankingSystem.services;

import com.training.BankingSystem.model.Customer;

public interface CustomerServicee {

	public Customer createCustomer(Customer customer);
	public Customer getCustomerDetails(Integer customerId);
	public Customer updateCustomer(Integer customerId,String customerName);
	
}
