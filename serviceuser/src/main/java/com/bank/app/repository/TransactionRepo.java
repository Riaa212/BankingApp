package com.bank.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.app.domain.Transactions;

public interface TransactionRepo extends JpaRepository<Transactions,Integer>
{
	 List<Transactions> findByTransactionDateBetween(LocalDate from, LocalDate to);
}
