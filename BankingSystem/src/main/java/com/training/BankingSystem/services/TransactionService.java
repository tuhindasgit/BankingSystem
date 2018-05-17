package com.training.BankingSystem.services;

import com.training.BankingSystem.model.Transaction;

public interface TransactionService {

public Transaction createTransaction();
public Transaction generateTransactionReport();
}
