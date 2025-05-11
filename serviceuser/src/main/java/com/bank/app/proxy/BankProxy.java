package com.bank.app.proxy;

import java.time.LocalDateTime;
import java.util.List;

import com.bank.app.domain.BankBranch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankProxy {

	private Integer id;
	private String bankName;
	private String IFSC;
	private String mainBranch;
	private String contactNumber;
	private String location;
//	private String bankCode;
	
	//one bank can have many branch

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
