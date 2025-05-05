package com.bank.app.service;

import java.util.List;

import com.bank.app.proxy.UserProxy;

public interface UserService {

	
	//create user
	public String createUser(UserProxy user);
	
	//update user
	public String updateUser(UserProxy user,Integer id);
	
	//delete user by id
	public String deleteUserById(Integer id);
	
	//get all users
	public List<UserProxy> getAllUsers();
	
	
}
