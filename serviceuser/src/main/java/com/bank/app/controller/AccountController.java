package com.bank.app.controller;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bank.app.domain.TransactionFilterRequest;
import com.bank.app.domain.Transactions;
import com.bank.app.helper.AccNumberGenerator;
import com.bank.app.proxy.AccountProxy;
import com.bank.app.repository.BankBranchRepo;
import com.bank.app.repository.TransactionRepo;
import com.bank.app.service.BankBranchService;
import com.bank.app.service.impl.AccountServiceImpl;
import com.bank.app.service.impl.TransactionServiceImpl;
@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

	@Autowired
	private AccountServiceImpl acc;
	
	@Autowired
	private BankBranchRepo brepo;
	
	//bank branch service
	@Autowired
	private BankBranchService branchService;
	
	@Autowired
	private AccNumberGenerator accGen;

	
	@Autowired
	private TransactionRepo trepo;
	
	//transaction service
	@Autowired
	private TransactionServiceImpl transService;
	
	@PostMapping("/create") //working
	public ResponseEntity<?> createAccount(@RequestBody AccountProxy account)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(acc.createAccount(account));
	}
	
	//deposit money
	@PostMapping("/deposit/{accNo}/{amount}")//working
	public ResponseEntity<?> deposit(@PathVariable("accNo") String accNo,@PathVariable("amount") Double amount)
	{		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transService.deposit(amount, accNo));
	}
	
	//withdrawal money
	@PostMapping("/withdrawal/{accNo}/{amount}") //working
	public ResponseEntity<?> withdrawal(@PathVariable("accNo") String accNo,@PathVariable("amount") Double amount)
	{		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transService.Withdrawal(amount, accNo));
	}

	//generate account number
	@GetMapping("/accNum") //working
	public ResponseEntity<?> generateAccNum()
	{		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(accGen.generateAccountNumber());
	}
	
	@PostMapping("/getUserByAcc/{accNo}/{userId}")
	public ResponseEntity<?> getuserByAccNum(@PathVariable String accNo,@PathVariable Integer userId)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(acc.getUserByAccountNum(accNo,userId));
	}
	
	//get total balance by account number
	@PostMapping("/getTotalBalance/{accNo}")
	public ResponseEntity<?> getTotalBalance(@PathVariable String accNo)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(acc.totalBalance(accNo));
	}
	
	//inner join on account
	@GetMapping("/getAllAccount")
	public ResponseEntity<?> getallAcc()
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(acc.getAllAccounts());
	}
	
	//get account details by account number
	@GetMapping("/getByAccNum/{accNum}")
	public ResponseEntity<?> getByAccNum(@PathVariable String accNum)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(acc.getByAccNo(accNum));
	}
	
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Integer userId)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(acc.getUserById(userId));
	}
	
	@GetMapping("/getAllTransactions")
	public ResponseEntity<?> getAllTransactions()
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transService.getAllTransactions());
	}
	
	@GetMapping("/getAllUserAccount")
	public ResponseEntity<?> getAllUserAccounts()
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(acc.getAllUserAccount());
	}
	
	
	 @PostMapping("/filter")
	  public ResponseEntity<?> filterTransactions(@RequestBody TransactionFilterRequest request) {
	        List<Transactions> filtered = transService.getTransactionsByDate(request);
	        return ResponseEntity.ok(filtered);
	  }
	  

}
