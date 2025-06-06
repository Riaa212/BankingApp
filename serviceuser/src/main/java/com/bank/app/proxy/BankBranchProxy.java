package com.bank.app.proxy;

import java.time.LocalDate;
import java.util.List;

import com.bank.app.domain.Accounts;
import com.bank.app.domain.Bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankBranchProxy {

	private Integer id;
	private String branchName;
	private String branchAddress;
	private String contactNumber;
	
	private Bank bank;
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
//	private List<Accounts> accounts;
}
