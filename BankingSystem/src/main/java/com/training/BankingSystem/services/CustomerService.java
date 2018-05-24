package com.training.BankingSystem.services;

import com.training.bankingsystem.model.Customer;

/**
 * @author tuhin
 *
 */
public interface CustomerService {

	/**
	 * Interface for creating a new customer
	 */
	Customer createCustomer(Customer customer);
	
	public Customer getCustomerDetails(Integer customerId);
	public Customer updateCustomer(Integer customerId,String customerName);
	
}
