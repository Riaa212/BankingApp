package com.bank.app.domain;

import java.time.LocalDate;

import com.bank.app.enums.CardTypeEnum;
import com.bank.app.enums.StatusEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Card {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String cardNumber;
	private LocalDate expiryDate;
	private String cvv;
//	accountId (int) – Foreign key referring to the account linked with the card.
	
	@Enumerated(EnumType.STRING)
	private CardTypeEnum cardType;
	
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	//card is linked with one account
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="account_id")
	private Accounts accounts;
//	Many-to-one relationship with Account (A card is linked to a specific account).
}
