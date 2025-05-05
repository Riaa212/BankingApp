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

import com.bank.app.proxy.UserProxy;
import com.bank.app.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllUsers()
	{
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getAllUsers());
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody UserProxy user)
	{
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.createUser(user));
	}
	
	@DeleteMapping("/deleteById/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable Integer userId)
	{
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.deleteUserById(userId));
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<?> updateUserById(@RequestBody UserProxy user,@PathVariable Integer userId)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(user, userId));
	}
}
