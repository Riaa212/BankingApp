package com.bank.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.domain.Accounts;
import com.bank.app.domain.UserEntity;
import com.bank.app.enums.StatusEnum;
import com.bank.app.exceptionHandling.UserNotFound;
import com.bank.app.helper.AESUtils;
import com.bank.app.helper.AccNumberGenerator;
import com.bank.app.helper.Utils;
import com.bank.app.proxy.UserProxy;
import com.bank.app.repository.AccountRepo;
import com.bank.app.repository.UserRepo;
import com.bank.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{


	@Autowired
	private Utils helper;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private AccountRepo accRepo;
	
	@Autowired
	private AccNumberGenerator accGen;
	
	@Override
	public List<UserProxy> getAllUsers() {
		
		
		List<UserEntity> users = userRepo.findAll();
		return helper.convertList(users, UserProxy.class);
	}

	
	//register user
	@Override
	public String createUser(UserProxy user) {
		
		System.err.println(user);
		
		Optional<UserEntity> byEmail = userRepo.findByEmail(user.getEmail());
				//.orElseThrow(new UserNotFound("user not found.."));
		
		if(byEmail.isPresent())
		{
			return "email already taken";
		}
		
//		user.set
		
		//set account status active
		user.setStatus(StatusEnum.Active);
		
		//generate account number 
		user.getAccounts().stream().forEach(a->
		{
		a.setAccountNumber(accGen.generateAccountNumber());
		a.setBalance(0.0);
		});
//		createUserBankAccount();
		user.setRequestToAcc(true);
//		user.setNameDecrypted(AESUtils.decrypt(user.getNameEncrypted()));
		userRepo.save(helper.convert(user, UserEntity.class));
		return "user Register successfully";
	}

	private void createUserBankAccount()
	{
		List<UserEntity> userTocreateAcc = userRepo.findUserTocreateAcc();
		
		Accounts account=new Accounts();
		
		//	System.err.println(userTocreateAcc);
		
//		userTocreateAcc.stream().forEach(a->
//		{
//		account.setAccountNumber(accGen.generateAccountNumber());
//		account.setBalance(0.0);
//		account.setUser(userTocreateAcc.get(0));
//		
//		accRepo.save(account);
		
//		a.setAccountNumber(accGen.generateAccountNumber());
//		a.setBalance(0.0);
//		});
		
//		Optional<UserEntity> byId = userRepo.findById(userId);
//		
//		if(byId.isPresent())
//		{
//			UserEntity userEntity = byId.get();
//			if(userEntity.getRequestToAcc().equals(true))
//			{
//				System.err.println(userEntity);
//			}
//		}
//		return null;
	}
	
	@Override
	public String updateUser(UserProxy user, Integer id) {
		Optional<UserEntity> userById = userRepo.findById(id);
		
		UserEntity userNotFound = userById.orElseThrow(()->new UserNotFound("UserNot Found.."));
	
		if(userById.isPresent())
		{
			UserEntity userEntity = userById.get();
			userEntity.setFirstName(user.getFirstName());
			userEntity.setLastName(user.getLastName());
			userEntity.setEmail(user.getEmail());
			userEntity.setDob(user.getDob());
			userEntity.setPhoneNumber(user.getPhoneNumber());
			userEntity.setAddress(user.getAddress());
			userRepo.save(userEntity);
			return "user updated successfully";
		}
//		 throw new UserNotFound("user not found","404");
		return "something went wrong";
	}

	@Override
	public String deleteUserById(Integer userId) {
		Optional<UserEntity> byId = userRepo.findById(userId);
		if(byId.isPresent())
		{
			UserEntity userEntity = byId.get();
			userRepo.delete(userEntity);
			return "user deleted successfully";
		}
		return "something went wrong";
	}
	
	public void saveUser(UserEntity user) {
	    user.setNameEncrypted(AESUtils.encrypt(user.getNameDecrypted()));
	    userRepo.save(user);
	}
	
	public UserEntity getUser(Integer id) {
	    UserEntity user = userRepo.findById(id).get();
	    user.setNameDecrypted(AESUtils.decrypt(user.getNameEncrypted()));
	    return user;
	}


}
