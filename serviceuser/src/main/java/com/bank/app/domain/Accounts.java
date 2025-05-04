package com.bank.app.domain;

import java.time.LocalDate;

import com.bank.app.enums.AccountTypeEnum;
import com.bank.app.enums.StatusEnum;

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
public class Accounts {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String accountNumber;
	@Enumerated(EnumType.STRING)
	private AccountTypeEnum accountType;
	private Double balance;
	private String branch;
	@Enumerated(EnumType.STRING)
	private StatusEnum accstatus;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	
	
	
//	Many-to-one relationship with User (An account belongs to a single user).
//	One-to-many relationship with Transaction (An account will have many transactions).
}
