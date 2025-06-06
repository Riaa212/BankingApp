package com.bank.app.service.impl;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.domain.Bank;
import com.bank.app.domain.BankBranch;
import com.bank.app.helper.Utils;
import com.bank.app.proxy.BankBranchProxy;
import com.bank.app.repository.BankBranchRepo;
import com.bank.app.repository.BankRepo;
import com.bank.app.service.BankBranchService;

@Service
public class BankBranchServiceImpl implements BankBranchService
{
	
	@Autowired
	private Utils helper;

	@Autowired
	private BankBranchRepo branchRepo;
	
	@Autowired
	private BankRepo bankRepo;
	
	@Override
	public String createBankBranch(BankBranchProxy bankBranch) {
		System.err.println(bankBranch);
		branchRepo.save(helper.convert(bankBranch,BankBranch.class));
		return "bank branch register successfully";
	}

	//delete bank branch
	@Override
	public String deleteBankBranch(Integer branchId) {
//		bankRepo.findByBankName(null);
		
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
		System.err.println(bankBranch+"\n"+byId);
		if(byId.isPresent())
		{
				BankBranch bankBranchObj = byId.get();
	
				if(bankBranch.getBranchName()!=null)
				{
					
					bankBranchObj.setBranchName(bankBranch.getBranchName());	
				}
				if(bankBranch.getContactNumber()!=null)
				{
					
					bankBranchObj.setContactNumber(bankBranch.getContactNumber());	
				}
				
				if(bankBranch.getBranchName()!=null)
				{
					
					bankBranchObj.setBranchName(bankBranch.getBranchName());	
				}
					
				branchRepo.save(bankBranchObj);	
				return "bank branch details updated successfully";
		}
		return "something went wrong";
	}
	
	//get all branch of bank by bank name
	public List<BankBranchProxy> getAllBranchByBankName(String bank)
	{
		Optional<Bank> byBankName = bankRepo.findByBankName(bank);
		
		if(byBankName.isPresent())
		{
			Bank bankObj = byBankName.get();
//			System.err.println("bank name==="+bankObj.getBankName());
//			System.err.println("bank name==="+bankObj.getId());
			
			//get all branches
			List<BankBranch> all = branchRepo.findAll();
//			System.err.println("\nAll branch==="+all);
			
			//filter the bank branches
			List<BankBranch> bankBranch = all.stream().filter(a->a.getBank().getId()==bankObj.getId()).collect(Collectors.toList());
			
//			System.err.println("Result===>"+bankBranch);
			return helper.convertList(bankBranch, BankBranchProxy.class);
			
		}
		return null;
	}
	
	//get all branch by bank id
	public List<BankBranchProxy> getBranchByBankId(Integer bid)
	{
		List<BankBranch> all = branchRepo.findAll();
		
		//System.err.println(all);
		
		List<BankBranch> collect = all.stream().filter(a->a.getBank().getId().equals(bid)).collect(Collectors.toList());
		
//		System.out.println("all branch:"+collect);
	
		return helper.convertList(collect, BankBranchProxy.class);
	}

	public String deleteBrachById(Integer branchId)
	{
		branchRepo.deleteById(branchId);
		return "branch deleted successfully";
	}
}
