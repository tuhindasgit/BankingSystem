package com.training.retailerboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.training.retailerboot.model.Customer;

public interface CustomerRepo extends CrudRepository<Customer,String> {

//	@Query
//	public Customer getByName(String customerName);
	
	
}
