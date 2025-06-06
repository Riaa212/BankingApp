package com.bank.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.app.domain.Accounts;

public interface AccountRepo extends JpaRepository<Accounts,Integer>
{
		Optional<Accounts> findByAccountNumber(String accNo);

//		@Query(value="select a from Accounts a inner join a.bank b inner join a.user u")
		
		//JPQL
		//get common data 
		@Query(value="select a from Accounts a inner join a.bank b")
		List<Accounts> getAccount();
		
		
		@Query(value="select a from Accounts a inner join a.bank b where a.accountNumber=:accNo")
		List<Accounts> getByAccNo(@Param("accNo") String accNo);

		
		@Query(value="select a from Accounts a ORDER BY a limit 5")
		List<Accounts> getAllAccounts();
}

//--> Join multiple table 
//	@Query(value="select a from Accounts a inner join a.bank b inner join a.user u")

//	@Query(value = "SELECT * FROM Accounts WHERE  accstatus='Active'", nativeQuery = true)

//@Query(value="select a from Accounts a inner join a.bank b where b.id=1")