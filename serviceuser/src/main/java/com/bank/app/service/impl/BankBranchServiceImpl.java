package com.bank.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.domain.BankBranch;
import com.bank.app.helper.Utils;
import com.bank.app.proxy.BankBranchProxy;
import com.bank.app.repository.BankBranchRepo;
import com.bank.app.service.BankBranchService;

@Service
public class BankBranchServiceImpl implements BankBranchService
{
	
	@Autowired
	private Utils helper;

	@Autowired
	private BankBranchRepo branchRepo;
	
	@Override
	public String createBankBranch(BankBranchProxy bankBranch) {
		branchRepo.save(helper.convert(bankBranch,BankBranch.class));
		return "bank branch register successfully";
	}

	@Override
	public String deleteBankBranch(Integer branchId) {
		Optional<BankBranch> byId = branchRepo.findById(branchId);
		if(byId.isPresent())
		{
			BankBranch bankBranch = byId.get();
			branchRepo.delete(bankBranch);
			return "bank branch deleted successfully";
		}
		return "something went wrong";
	}

	@Override
	public List<BankBranchProxy> getAllBankBranch() {
		List<BankBranch> all = branchRepo.findAll();
		return helper.convertList(all, BankBranchProxy.class);
	}

	@Override
	public String updateBankBranch(BankBranchProxy bankBranch, Integer bid) {
		
		Optional<BankBranch> byId = branchRepo.findById(bid);
		if(byId.isPresent())
		{
			BankBranch bankBranchObj = byId.get();
			bankBranchObj.setBranchName(bankBranch.getBranchName());
			bankBranchObj.setBranchAddress(bankBranch.getBranchAddress());
			bankBranchObj.setContactNumber(bankBranch.getContactNumber());
			bankBranchObj.setAccounts(bankBranch.getAccounts());
			
			branchRepo.save(bankBranchObj);
			return "bank branch details updated successfully";
		}
		return "something went wrong";
	}

}
