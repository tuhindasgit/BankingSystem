package com.training.BankingSystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.Customer;
import com.training.BankingSystem.repository.BankRepo;
import com.training.BankingSystem.repository.CustomerRepo;
/*
 * Customer services
 */
@Service
public class CustomerServiceImpl implements CustomerServicee{

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	BankServiceImpl bankservice;

	/*
	 * (non-Javadoc)
	 * @see com.training.BankingSystem.services.CustomerServicee#createCustomer(com.training.BankingSystem.model.Customer)
	 */
	@Override
	public Customer createCustomer(final Customer customer) throws MyException {
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
		final Optional<Customer> customer1 = customerRepo.findById(customerId);
		if(customer1.isPresent())
		{
		
	return customer1.get();
		}
		else
		{
			throw new MyException("Id is not present...invalid");
		}
	}
	}


