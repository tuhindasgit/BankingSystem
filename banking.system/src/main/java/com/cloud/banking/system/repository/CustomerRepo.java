package com.cloud.banking.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.banking.system.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
