package com.bank.app.domain;

import java.time.LocalDate;

import com.bank.app.enums.TransactionStatus;
import com.bank.app.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transactions {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
//	Foreign key referring to the sender's account (if applicable).
	private Integer senderAccountId;
	
//	Foreign key referring to the receiver's account (if applicable)
	private Integer receiverAccountId;

	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus;
	
	private LocalDate transactionDate;
	
	private String description;
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	
	
	
//	Many-to-one relationship with Account (A transaction involves one or more accounts).
//	Many-to-one relationship with User (A transaction is associated with users).
}
