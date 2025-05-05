package com.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.app.domain.BankBranch;

public interface BankBranchRepo  extends JpaRepository<BankBranch,Integer>
{

}
