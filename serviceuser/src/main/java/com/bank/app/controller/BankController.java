package com.bank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.proxy.BankProxy;
import com.bank.app.service.impl.BankServiceImpl;

@RestController
@RequestMapping("/bank")
public class BankController {

	@Autowired
	private BankServiceImpl bankService;
	
	@PostMapping("/register") //working
	public ResponseEntity<?> registerBank(@RequestBody BankProxy bank)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bankService.RegisterBank(bank));
	}
	
	//get all banks
	@GetMapping("/getAll") //working
	public ResponseEntity<?>  getAllBank()
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bankService.getAllBanks());
	}
	
	//get bank by name
	@GetMapping("/getBankName/{name}") //working
	public ResponseEntity<?>  getBankByName(@PathVariable String name)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bankService.getBankByName(name));
	}
	
	//delete all bank
	@DeleteMapping("/deleteAllBank") //working
	public ResponseEntity<?>  deleteAllBank()
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bankService.deleteAllBank());
	}
	
	//get bank by id
	@GetMapping("/getBankById/{id}") //working
	public ResponseEntity<?>  getBankById(@PathVariable Integer id)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bankService.getBankById(id));
	}
}
	