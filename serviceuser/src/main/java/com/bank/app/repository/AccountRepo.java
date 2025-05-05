package com.bank.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.app.domain.Accounts;

public interface AccountRepo extends JpaRepository<Accounts,Integer>
{
	Optional<Accounts> findByAccountNumber(String accNo);
}
