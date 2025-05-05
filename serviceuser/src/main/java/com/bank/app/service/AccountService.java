package com.bank.app.service;

import java.util.List;

import com.bank.app.proxy.AccountProxy;

public interface AccountService {

	public String createAccount(AccountProxy account);
	
	//get total balance by account no 
	public Double totalBalance(String accNo);
	
	//get account details by user id
	public List<AccountProxy> getAccountDetails(Integer userId);
	
	
}
