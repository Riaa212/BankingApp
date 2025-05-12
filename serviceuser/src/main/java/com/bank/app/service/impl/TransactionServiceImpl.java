package com.bank.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.domain.Accounts;
import com.bank.app.domain.Transactions;
import com.bank.app.enums.TransactionStatus;
import com.bank.app.enums.TransactionType;
import com.bank.app.helper.Utils;
import com.bank.app.proxy.TransactionsProxy;
import com.bank.app.repository.AccountRepo;
import com.bank.app.repository.TransactionRepo;
import com.bank.app.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService
{

	@Autowired
	private Utils helper;
	
	@Autowired
	private AccountRepo accRepo; 
	
	@Autowired
	private TransactionRepo transRepo;
	
	//deposit 
	@Override
	public String deposit(Double amount, String accNumber) {
		
		Optional<Accounts> byAccountNumber = accRepo.findByAccountNumber(accNumber);
		
//		System.err.println(byAccountNumber);
		
		if(byAccountNumber.isPresent())
		{
			Accounts accounts = byAccountNumber.get();
			
			System.out.println("account data:"+accounts);
			
			
			Transactions trans=new Transactions();
			
//			trans.getTransactionStatus();
			if(amount>0)
			{
				amount+=accounts.getBalance();

				//System.err.println("amount=="+amount+"\n"+accounts);
				accounts.setBalance(amount);
				trans.setAccount(accounts);
				trans.setTransactionType(TransactionType.Deposit);
				trans.setAmount(amount);
				accRepo.save(accounts);
				trans.setTransactionStatus(TransactionStatus.Success);
				transRepo.save(trans);
//				System.err.println("amount=="+amount+"\n"+accounts);
				return "amount deposit successfully \n Total Balance:"+amount;
			}
			else
			{
				trans.setTransactionStatus(TransactionStatus.Failed);
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
			
			Transactions trans=new Transactions();
			if(amount<0)
			{
				return "Invalid Amount";
			}
			
			if(amount>accounts.getBalance())
			{
				return "You can't widthaw money";
			}
			trans.setAccount(accounts);
			trans.setTransactionType(TransactionType.Withdrawal);
			trans.setAmount(amount);
//			accounts.getBalance()=accounts.getBalance()-amount;
			
			accounts.setBalance(accounts.getBalance()-amount);
			System.err.println(accounts.getBalance());
			accRepo.save(accounts);
			trans.setTransactionStatus(TransactionStatus.Success);
			transRepo.save(trans);
		}
		return null;
	}

	public List<TransactionsProxy> getAllTransactions()
	{
		List<Transactions> all = transRepo.findAll();
		return helper.convertList(all, TransactionsProxy.class);
	}
}
