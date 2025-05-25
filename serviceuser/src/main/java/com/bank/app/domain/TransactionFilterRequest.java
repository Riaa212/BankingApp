package com.bank.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionFilterRequest {

	  private String fromDate;  // format: yyyy-MM-dd
	  private String toDate;
}
