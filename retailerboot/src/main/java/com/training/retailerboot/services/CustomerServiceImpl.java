package com.training.retailerboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.retailerboot.exception.MyException;
import com.training.retailerboot.model.Customer;
import com.training.retailerboot.repository.CustomerRepo;

@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerRepo custRepo;
	
	
	public List<Customer> showall()
	{
		List<Customer> custlist=new ArrayList<>();
		custRepo.findAll().forEach(custlist::add);
		return custlist;
	}

	public Customer getone(String customer_name) throws MyException
	{
		Customer cust;
		Optional<Customer> givenCust=custRepo.findById(customer_name);
		if(givenCust.isPresent())
		{
			cust=givenCust.get();
			return cust;
		}
		else
		{
			throw new MyException("Customer not present");
		}
	}

	public Customer addcustomer(Customer customer) {
		Customer cust=custRepo.save(customer);
		return cust;
	}

	public void updatecustomer(Customer customer,String customer_name) {
		custRepo.save(customer);
	}

	public void deletecustomer(String customer_name) {
		
		custRepo.deleteById(customer_name);
		
	}
	
	
}
