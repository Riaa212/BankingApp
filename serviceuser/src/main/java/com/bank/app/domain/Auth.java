package com.bank.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth {

	private Integer id;
//	userId (int) – Foreign key referring to the user
//	passwordHash (String) – The hashed password.
//	jwtToken (String) – The JWT token issued after successful login.
//	lastLogin (Date) – The last time the user logged in.
//	createdAt (Date) – When the authentication record was created.
//	One-to-one relationship with User (Each user has one set of authentication details).
}
