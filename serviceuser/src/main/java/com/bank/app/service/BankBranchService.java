package com.bank.app.service;

import java.util.List;

import com.bank.app.proxy.BankBranchProxy;

public interface BankBranchService {

	
	//register bank branch
	public String createBankBranch(BankBranchProxy bankBranch);
	
	//delete bank branch by id
	public String deleteBankBranch(Integer branchId);
	
	//get all bank branch
	public List<BankBranchProxy> getAllBankBranch();
	
	//update branch data
	public String updateBankBranch(BankBranchProxy bankBranch,Integer bid);
}
