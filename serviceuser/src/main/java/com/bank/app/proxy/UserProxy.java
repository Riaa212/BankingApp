package com.bank.app.proxy;

import java.time.LocalDate;
import java.util.List;

import com.bank.app.domain.Accounts;
import com.bank.app.domain.Transactions;
import com.bank.app.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProxy {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private String address;
	private LocalDate dob;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	private StatusEnum status;
	
	//one user can have multiple accounts
	//private List<Accounts> accounts;
	
	private Boolean requestToAcc=false;
	
	//one user can have multiple transactions
	private List<Transactions> transcations;
	
	private List<Accounts> accounts;
	
    private String nameEncrypted;
	
    private String nameDecrypted;

}
