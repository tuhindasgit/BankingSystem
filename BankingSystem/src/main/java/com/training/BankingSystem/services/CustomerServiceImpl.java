package com.training.BankingSystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.Customer;
import com.training.BankingSystem.repository.CustomerRepo;
/*
 * Customer services
 */
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	BankService bankservice;

	/**
	 * 
	 * @param customer
	 * @return
	 * @throws MyException
	 */
	@Override
	public Customer createCustomer(final Customer customer) {
		final Integer id=customer.getBankId();
		final Optional<Bank> bank=bankservice.findById(id);
		if (bank.isPresent()) {
			final Customer cust = customerRepo.save(customer);
			return cust;
		} else {
			throw new MyException("Customer is not mapped with any bank");

		}
	}
/*
 * (non-Javadoc)
 * @see com.training.BankingSystem.services.CustomerServicee#getCustomerDetails(java.lang.Integer)
 */
	@Override
	public Customer getCustomerDetails(final Integer customerId) {
		final Optional<Customer> customerOption = customerRepo.findById(customerId);
		if(customerOption.isPresent())
		{
		
	return customerOption.get();
		}
		else
		{
			throw new MyException("Id is not present...invalid");
		}
	}
	
	@Override
	public Customer updateCustomer(Integer customerId, String customerName) {
	
		final Optional<Customer> customerOption = customerRepo.findById(customerId);
		System.out.println("in");
		if(customerOption.isPresent())
		{
			
			Customer newCustomer= customerOption.get();
			System.out.println(newCustomer);
			newCustomer.setName(customerName);
			
			return customerRepo.save(newCustomer);
	}
		else
			{
			throw new MyException("not updated");
			}}
	}


