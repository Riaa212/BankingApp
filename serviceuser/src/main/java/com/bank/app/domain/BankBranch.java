package com.bank.app.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankBranch {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String branchName;
	private String branchAddress;
	private String contactNumber;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="bank_id")
//	private List<BankBranch> bankBranch;
	
//	@ManyToOne(cascade=CascadeType.MERGE)
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="bank_id")
	private Bank bank;
	
//	private String branchCode;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	
	
//	A branch can serve multiple accounts
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="bank_id")
//	private List<Accounts> accounts;
	
//	One-to-many relationship with Account (A branch can serve multiple accounts).
}
