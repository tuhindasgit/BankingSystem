package com.training.BankingSystem.BankTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.training.BankingSystem.model.Customer;

public class TestCustomer {

//	@Autowired
//	Customer customer;
	@Test
	public void testCustomer() {
		Customer customer=new Customer();
		 final String uri = "http://localhost:8082/addcustomer";
		 RestTemplate restTemplate = new RestTemplate();
		 
		   customer.setBankId(5);
		   customer.setName("tuhin");
		   customer.setPin(102);
		  	 		   
		    Customer result = restTemplate.postForObject( uri, customer, Customer.class);
		 System.out.println(customer);
		 System.out.println("   sggs    "+result);
		   assertEquals("tuhin",result.getName());
	}
}
