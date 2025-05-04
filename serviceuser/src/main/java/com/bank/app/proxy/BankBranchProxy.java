package com.bank.app.proxy;

import java.time.LocalDate;

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
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
}
