package com.bank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.proxy.BankBranchProxy;
import com.bank.app.service.impl.BankBranchServiceImpl;

@RestController
@RequestMapping("/branch")
public class BankBranchController {

	@Autowired
	private BankBranchServiceImpl branchService;
	
	//create bank branch
	@PostMapping("/create") //working
	public ResponseEntity<?> createBankBranch(@RequestBody BankBranchProxy branch)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(branchService.createBankBranch(branch));
	}
	
	//update bank branch
	@PutMapping("/update/{bid}")  //working
	public ResponseEntity<?> updateBankBranch(@RequestBody BankBranchProxy branch,@PathVariable Integer bid)
	{
		return ResponseEntity.status(HttpStatus.OK).body(branchService.updateBankBranch(branch, bid));
	}
	
	//update bank branch
	@GetMapping("/getAllBranch/{bankName}")  //working
	public ResponseEntity<?> getAllBankBranch(@PathVariable String bankName)
	{
		return ResponseEntity.status(HttpStatus.OK).body(branchService.getAllBranchByBankName(bankName));
	}
	
	//get all branch of bank  by bank name
	@GetMapping("/getBranchById/{bankName}") //working 
	public ResponseEntity<?> getBranchByBankId(@PathVariable Integer bankName)
	{
		return ResponseEntity.status(HttpStatus.OK).body(branchService.getBranchByBankId(bankName));
	}

	@DeleteMapping("/deleteBranchById/{branchId}") //working 
	public ResponseEntity<?> deleteBankBranchById(@PathVariable Integer branchId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(branchService.deleteBankBranch(branchId));
	}	
}
