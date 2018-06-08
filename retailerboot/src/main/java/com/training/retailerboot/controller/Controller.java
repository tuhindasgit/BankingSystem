package com.training.retailerboot.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.retailerboot.exception.MyException;
import com.training.retailerboot.model.Customer;
import com.training.retailerboot.services.CustomerServiceImpl;

@RestController
public class Controller {
	
	//private final static Logger LOGGER = Logger.getLogger(Controller.class);
	private final static Logger LOGGER = Logger.getLogger(Controller.class.getName());
	
	@Autowired
	private CustomerServiceImpl customerservice;
	
	@RequestMapping("/showallcustomer")
	public List<Customer> showall()
	{
		return customerservice.showall();
	}
	@RequestMapping("/showallcustomer/{customer_name}")
	public ResponseEntity<Customer> getOne(@PathVariable("customer_name") String customer_name)
	{	
		Customer cust=customerservice.getone(customer_name);
	if(customer_name==null)
	
	{
		throw new MyException("no customer present");
		}
	
	return new ResponseEntity<Customer>(cust,HttpStatus.CREATED); 
	}
	@RequestMapping(value="/addcustomer" ,method=RequestMethod.POST)
	public ResponseEntity<?> addcustomer(@RequestBody Customer customer)
	{
		 Customer cust=customerservice.addcustomer(customer);
		 if((customer.getCustomer_Id()==null)|| (customer.getCustomer_name()==null)||customer.getCustomer_address()==null)
			{
				return new ResponseEntity<String>("not present",HttpStatus.NOT_FOUND);
			}
			else
			{
			return new ResponseEntity<Customer>(cust,HttpStatus.CREATED); 
			}
	} 
	@RequestMapping(value="/updatecustomer/{customer_name}" ,method=RequestMethod.PUT)
	public void updatecustomer(@RequestBody Customer customer,@PathVariable String customer_name)
	{
		 customerservice.updatecustomer(customer,customer_name);
	} 
	@RequestMapping(value="/deletecustomer/{customer_name}" ,method=RequestMethod.DELETE)
	public void deletecustomer(@PathVariable String customer_name)
	{
		 customerservice.deletecustomer(customer_name);
	} 
//	@RequestMapping(value="/custom" )
//	public void custom()
//	{
//	Customer cust=new Customer();
//	Class c=cust.getClass();
//	Annotation an=c.getAnnotation(AnnotationMy.class);
//	AnnotationMy ant=(AnnotationMy) an;
//	System.out.println(ant.name());
//	}
}
