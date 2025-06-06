package com.bank.app.proxy;

import java.time.LocalDate;

import com.bank.app.domain.Bank;
import com.bank.app.domain.UserEntity;
import com.bank.app.enums.AccountTypeEnum;
import com.bank.app.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountProxy {

	private Integer id;
	private String accountNumber;
	private AccountTypeEnum accountType;
	private Double balance;
//	private String branch;
	private StatusEnum accstatus;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	private Bank bank; 
	
//	private UserEntity user;
	
//	Many-to-one relationship with User (An account belongs to a single user).
//	One-to-many relationship with Transaction (An account will have many transactions).
}
