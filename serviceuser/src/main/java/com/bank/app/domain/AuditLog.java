package com.bank.app.domain;

import java.time.LocalDate;

public class AuditLog {

	private Integer id;
//	userId (int) – Foreign key referring to the user who performed the action.
	private String action;
	private LocalDate timestamp;
	private String IpAddress;
	private LocalDate createdAt;
}
