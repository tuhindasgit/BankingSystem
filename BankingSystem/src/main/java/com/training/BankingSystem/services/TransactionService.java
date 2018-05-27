package com.training.BankingSystem.services;

import java.util.List;

import com.training.BankingSystem.model.Account;
import com.training.BankingSystem.model.Transaction;

public interface TransactionService {

public Transaction createTransaction(Account account,String message);
public List<Transaction> generateTransactionReport();
}
