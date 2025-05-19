package com.bank.app.exceptionHandling;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component	
public class UserNotFound extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private String error;
	private String errorCode;
	private String msg;
	
	public UserNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public UserNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public UserNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public UserNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
