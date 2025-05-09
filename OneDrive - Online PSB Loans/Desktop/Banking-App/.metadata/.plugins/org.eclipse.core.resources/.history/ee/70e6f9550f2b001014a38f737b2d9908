package com.bank.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.app.domain.Bank;

public interface BankRepo extends JpaRepository<Bank,Integer>
{
	
	Optional<Bank> findByBankName(String bankName);
}
