package com.bank.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.domain.Accounts;
import com.bank.app.helper.Utils;
import com.bank.app.repository.AccountRepo;
import com.bank.app.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService
{

	@Autowired
	private Utils helper;
	
	@Autowired
	private AccountRepo accRepo; 
	
	//deposit 
	@Override
	public String deposit(Double amount, String accNumber) {
		Optional<Accounts> byAccountNumber = accRepo.findByAccountNumber(accNumber);
	
		if(byAccountNumber.isPresent())
		{
			Accounts accounts = byAccountNumber.get();
			if(amount>0)
			{
				amount+=accounts.getBalance();
				System.err.println("amount=="+amount+"\n"+accounts);
				accounts.setBalance(amount);
				accRepo.save(accounts);
				System.err.println("amount=="+amount+"\n"+accounts);
				return "amount deposit successfully \n Total Balance:"+amount;
			}
			else
			{
				return "amount must be positive";
			}
		}
		return null;
	}

	//withdrawal
	@Override
	public String Withdrawal(Double amount, String accNumber) {
		
		Optional<Accounts> byAccountNumber = accRepo.findByAccountNumber(accNumber);
		
		if(byAccountNumber.isPresent())
		{
			Accounts accounts = byAccountNumber.get();
			
			if(amount<0)
			{
				return "Invalid Amount";
			}
			
			if(amount>accounts.getBalance())
			{
				return "You can't widthaw money";
			}
			
			amount+=accounts.getBalance();
		}
		return null;
	}

}
