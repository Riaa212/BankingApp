package com.bank.app.proxy;

import java.time.LocalDate;

import com.bank.app.domain.Accounts;
import com.bank.app.enums.TransactionStatus;
import com.bank.app.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsProxy {

private Integer id;
	
//	Foreign key referring to the sender's account (if applicable).
	private Integer senderAccountId;
	
//	Foreign key referring to the receiver's account (if applicable)
	private Integer receiverAccountId;

	private Double amount;
	
	private TransactionType transactionType;
	
	private TransactionStatus transactionStatus;
	
	private LocalDate transactionDate;
	
	private Accounts account;
	
	private String description;
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	
	
//	Many-to-one relationship with Account (A transaction involves one or more accounts).
//	Many-to-one relationship with User (A transaction is associated with users).
}
