package com.training.BankingSystem.services;

import com.training.BankingSystem.model.Customer;

/**
 * @author tuhin
 *
 */
public interface CustomerService {

	/**
	 * Interface for creating a new customer
	 */
	Customer createCustomer(Customer customer);
	/**
	 * 
	 * @param customerId
	 * @return Customer
	 */
	public Customer getCustomerDetails(Integer customerId);
	/**
	 * 
	 * @param customerId
	 * @param customerName
	 * @return Customer
	 * @throws CloneNotSupportedException 
	 */
	public Customer updateCustomer(Integer customerId,String customerName) throws CloneNotSupportedException;
	
}
