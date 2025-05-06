package com.bank.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.domain.Bank;
import com.bank.app.helper.Utils;
import com.bank.app.proxy.BankProxy;
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
	
	@Transactional
	@Override
	public String RegisterBank(BankProxy bank) {
//		bank.getBankBranch().stream().forEach(a->a.setId(bank.getBankBranch().get(0).getId()));
		bankRepo.save(helper.convert(bank,Bank.class));
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
}
