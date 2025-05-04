package com.bank.app.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	
	
//	A branch can serve multiple accounts
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="bank_id")
	private List<Accounts> accounts;
	
//	One-to-many relationship with Account (A branch can serve multiple accounts).
}
