package com.bank.app.service;

public interface TransactionService {

	public String deposit(Double amount,String accNumber);
	
	public String Withdrawal(Double amount,String accNumber);
}
