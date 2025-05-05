package com.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.app.domain.Transactions;

public interface TransactionRepo extends JpaRepository<Transactions,Integer>
{

}
