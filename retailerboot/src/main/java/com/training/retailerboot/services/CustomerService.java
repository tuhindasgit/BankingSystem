package com.training.retailerboot.services;

import java.util.List;

import com.training.retailerboot.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer);
	public List<Customer> getCustomerDetails(Integer customerId);
}
