package com.bank.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.domain.Bank;
import com.bank.app.domain.BankBranch;
import com.bank.app.helper.Utils;
import com.bank.app.proxy.BankProxy;
import com.bank.app.repository.AccountRepo;
import com.bank.app.repository.BankBranchRepo;
import com.bank.app.repository.BankRepo;
import com.bank.app.service.BankService;

import jakarta.transaction.Transactional;

@Service
public class BankServiceImpl implements BankService
{

	@Autowired
	private Utils helper;
	
	@Autowired
	private BankRepo bankRepo;
	
	@Autowired
	private BankBranchRepo branchRepo;
	
	@Autowired
	private AccountRepo accRepo;
	
	@Transactional
	@Override
	public String RegisterBank(BankProxy bank) {
		
		
		BankBranch branch=new BankBranch();
		
		//generate IFSC code
		Random random = new Random();
        int branchCode = 100000 + random.nextInt(900000);
		bank.setIFSC(bank.getBankName().toUpperCase()+"0"+branchCode);
		Bank bankObj = bankRepo.save(helper.convert(bank,Bank.class));
		
		branch.setContactNumber(bank.getContactNumber());
		branch.setBranchName(bank.getMainBranch());
		branch.setBranchAddress(bank.getLocation());
		branch.setBank(bankObj);
		branchRepo.save(branch);
//		System.err.println(bankObj);
		return "Bank register successfully";
	}

	public List<BankProxy> getAllBanks()
	{
		List<Bank> allBank = bankRepo.findAll();
		return helper.convertList(allBank,BankProxy.class);
	}
	
	public BankProxy getBankByName(String bankName)
	{
		Optional<Bank> byBankName = bankRepo.findByBankName(bankName);
		if(byBankName.isPresent())
		{
			Bank bank = byBankName.get();
			return helper.convert(bank, BankProxy.class);
		}
		return null;
	}
	
	public String deleteAllBank()
	{
		accRepo.deleteAll();
		branchRepo.deleteAll();
		bankRepo.deleteAll();
		return "deleted successfully";
	}
}
