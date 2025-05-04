package com.bank.app.proxy;

import java.time.LocalDate;

import com.bank.app.domain.Accounts;
import com.bank.app.domain.Card;
import com.bank.app.enums.CardTypeEnum;
import com.bank.app.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardProxy {

	private Integer id;
	private String cardNumber;
	private LocalDate expiryDate;
	private String cvv;
//	accountId (int) – Foreign key referring to the account linked with the card.
	private CardTypeEnum cardType;
	private StatusEnum status;
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	//card is linked with one account
	private Accounts accounts;
}
