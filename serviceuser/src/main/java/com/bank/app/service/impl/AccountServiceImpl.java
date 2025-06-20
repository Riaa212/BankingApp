package com.bank.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.domain.Accounts;
import com.bank.app.domain.UserEntity;
import com.bank.app.enums.StatusEnum;
import com.bank.app.helper.Utils;
import com.bank.app.proxy.AccountProxy;
import com.bank.app.proxy.UserProxy;
import com.bank.app.repository.AccountRepo;
import com.bank.app.repository.UserRepo;
import com.bank.app.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService
{

	@Autowired
	private AccountRepo accRepo;

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private Utils helper;
	
	
	@Override
	public Double totalBalance(String accNo) {
	 Optional<Accounts> byAccountNumber = accRepo.findByAccountNumber(accNo);
	 
	 if(byAccountNumber.isPresent())
	 {
		 Accounts accounts = byAccountNumber.get();
		 return accounts.getBalance();
	 }
	 return null;
	}

	//get account details
	@Override
	public List<AccountProxy> getAccountDetails(Integer userId) {
	
		Optional<UserEntity> byId = userRepo.findById(userId);
		
		if(byId.isPresent())
		{
			UserEntity userEntity = byId.get();
//			List<Accounts> accounts = userEntity.getAccounts();
			return helper.convertList(null, AccountProxy.class);
		}
		return null;
	}

	
	//create account
	@Override
	public String createAccount(AccountProxy account) {
//		account.setAccountNumber(UUID.randomUUID().toString());
		account.setAccstatus(StatusEnum.Active);
		account.setBalance(0.0);
//		account.setAccountType(AccountTypeEnum.Savings);
		accRepo.save(helper.convert(account, Accounts.class));
		return "account created successfully";
	}
	
	public List<AccountProxy> getUserByAccountNum(String accNo,Integer userId)
	{
		Optional<Accounts> byAccountNumber = accRepo.findByAccountNumber(accNo);
		
		List<UserEntity> userlst = userRepo.findAll();
//		System.out.println(userlst);

		Optional<UserEntity> byId = userRepo.findById(userId);
		List<Accounts> collect=null;
		if(byId.isPresent())
		{
			UserEntity userEntity = byId.get();
//			System.err.println("======="+userEntity);
//			collect = userEntity.
//			getAccounts().
//			stream().
//			filter(a->a.getAccountNumber().equals(accNo)).collect(Collectors.toList());
//			System.err.println("Account Details=="+collect);
		}
		
		if(byAccountNumber.isPresent())
		{
			Accounts accounts = byAccountNumber.get();
			
//			System.err.println(accounts);
			return helper.convertList(collect, AccountProxy.class);
		}
		return null;
	}
	
	public List<Accounts> getAllAccounts()
	{
		List<Accounts> account = accRepo.getAccount();
		return account;
	}

	//get accounts 
	public List<Accounts> getByAccNo(String accNo)
	{
		List<Accounts> byAccNo = accRepo.getByAccNo(accNo);
		return byAccNo;
	}
	
	public UserProxy getUserById(Integer userId)
	{
		Optional<UserEntity> byId = userRepo.findById(userId);
		if(byId.isPresent())
		{	
			UserEntity userEntity = byId.get();
			return helper.convert(userEntity, UserProxy.class);
		}
		return null;
	}
	
	public List<AccountProxy> getAllUserAccount()
	{
			List<Accounts> allAccounts = accRepo.getAllAccounts();
	        return helper.convertList(allAccounts, AccountProxy.class);
	}
	
	public String frezeeAcc(String accNo)
	{
		Optional<Accounts> byAccountNumber = accRepo.findByAccountNumber(accNo);
		
		if(byAccountNumber.isPresent())
		{
			Accounts accounts = byAccountNumber.get();
			
			accounts.setFreeze(true);
			accounts.setAccstatus(StatusEnum.Frezee);
			
			accRepo.save(accounts);
			return "account freeze successfully";
		}
		return null;
	}
}
