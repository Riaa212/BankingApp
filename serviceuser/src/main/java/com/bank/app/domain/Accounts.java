package com.bank.app.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.bank.app.enums.AccountTypeEnum;
import com.bank.app.enums.StatusEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
//	private String branch;
	@Enumerated(EnumType.STRING)
	private StatusEnum accstatus;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="bank_id")
	private Bank bank; 

	private Boolean freeze=false;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id")
//	private UserEntity user;
	
//	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="branch_id")
//	private BankBranch bank;
	
//	Many-to-one relationship with User (An account belongs to a single user).
//	One-to-many relationship with Transaction (An account will have many transactions).
}
