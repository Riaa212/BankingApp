package com.bank.app.domain;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
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
public class AuditLog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
//	userId (int) – Foreign key referring to the user who performed the action.
	private String action;
	private LocalDate timestamp;
	private String IpAddress;
	private LocalDate createdAt;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private UserEntity user;
}
