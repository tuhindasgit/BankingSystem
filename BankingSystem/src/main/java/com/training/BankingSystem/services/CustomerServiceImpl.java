package com.training.BankingSystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.BankingSystem.exception.MyException;
import com.training.BankingSystem.model.Bank;
import com.training.BankingSystem.model.Customer;
import com.training.BankingSystem.repository.BankRepo;
import com.training.BankingSystem.repository.CustomerRepo;
@Service
public class CustomerServiceImpl implements CustomerServicee{

	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	BankRepo bankRepo;
	
	@Override
	public Customer createCustomer(Customer customer) {
		Integer id=customer.getBankId();
		Optional<Bank> bank=bankRepo.findById(id);
		if (bank.isPresent()) {
			Customer cust = customerRepo.save(customer);
			return cust;
		} else {
			throw new MyException("invalid input,provide valid ammount..invalid");

		}
	}

	@Override
	public Customer getCustomerDetails(Integer customerId) {
		Optional<Customer> customer1 = customerRepo.findById(customerId);
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


