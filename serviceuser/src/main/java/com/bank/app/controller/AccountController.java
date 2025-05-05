package com.bank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.proxy.AccountProxy;
import com.bank.app.repository.BankBranchRepo;
import com.bank.app.service.BankBranchService;
import com.bank.app.service.impl.AccountServiceImpl;
import com.bank.app.service.impl.TransactionServiceImpl;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl acc;
	
	@Autowired
	private BankBranchRepo brepo;
	
	//bank branch service
	@Autowired
	private BankBranchService branchService;
	
	//transaction service
	@Autowired
	private TransactionServiceImpl transService;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createAccount(@RequestBody AccountProxy account)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(acc.createAccount(account));
	}
	
	@PostMapping("/deposit/{accNo}/{amount}")
	public ResponseEntity<?> deposit(@PathVariable("accNo") String accNo,@PathVariable("amount") Double amount)
	{		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transService.deposit(amount, accNo));
	}
	
	@PostMapping("/withdrawal")
	public ResponseEntity<?> withdrawal(String accNo,Double amount)
	{		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transService.Withdrawal(amount, accNo));
	}

}
