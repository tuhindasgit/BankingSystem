package com.cloud.banking.system.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cloud.banking.system.exception.BankException;
import com.cloud.banking.system.model.Bank;
import com.cloud.banking.system.model.Customer;
import com.cloud.banking.system.repository.CustomerRepo;

/**
 * @author tuhindas
 *
 */
@Service
@Configuration
@PropertySource("classpath:message.properties")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	BankService bankservice;
	
	@Autowired
	Environment env;
	
	@Override
	public Customer createCustomer(Customer customer) throws BankException {
		final Integer id=customer.getBankId();
		final Optional<Bank> bank=bankservice.findById(id);
		if (bank.isPresent()) {
			final Customer cust = customerRepo.save(customer);
			return cust;
		} else {
			throw new BankException(env.getProperty("CustomerBankId"));

		}
	}

	@Override
	public Customer getCustomerDetails(Integer customerId) throws BankException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Integer customerId, String customerName) throws BankException {
		// TODO Auto-generated method stub
		return null;
	}

}
