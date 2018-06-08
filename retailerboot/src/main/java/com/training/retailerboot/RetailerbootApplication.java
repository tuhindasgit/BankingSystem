package com.training.retailerboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.training.retailerboot.model.Customer;

@SpringBootApplication
public class RetailerbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailerbootApplication.class, args);
		updateCustomer();
	}
	
	
	private static void getCustomer()
	{
	    final String uri = "http://localhost:8082/showallcustomer/";
	    RestTemplate restTemplate = new RestTemplate();
	     
	    ResponseEntity<Customer[]> custentity= restTemplate.getForEntity(uri, Customer[].class);
	     
	    for(Customer cust:custentity.getBody())
	    System.out.println(cust);
	}
	private static void createEmployee()
	{
	    final String uri = "http://localhost:8082/addcustomer";
	 
	    Customer customer = new Customer(115, "Adam", "Gilly");
	 
	    RestTemplate restTemplate = new RestTemplate();
	    Customer result = restTemplate.postForObject( uri, customer, Customer.class);
	 
	    System.out.println(result);
	}
	private static void getCustomerById()
	{
	    final String uri = "http://localhost:8082/showallcustomer/{customer_name}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("customer_name", "abhishecbk");
	    RestTemplate restTemplate = new RestTemplate();
	    Customer result = restTemplate.getForObject(uri, Customer.class, params);
	     
	    System.out.println(result);
	}
	private static void updateCustomer()
	{
	    final String uri = "http://localhost:8082/updatecustomer/{customer_name}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("customer_name", "Adam");
	   
	     
	    Customer updatedCustomer = new Customer(200, "New Name", "Gilly");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.put ( uri, updatedCustomer, params);
	}
}
