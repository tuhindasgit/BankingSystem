package com.training.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.BankingSystem.model.TestDenomination;

public interface TestDenmRepo extends JpaRepository<TestDenomination, Integer> {

}
