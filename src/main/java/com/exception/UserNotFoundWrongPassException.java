package com.exception;


@SuppressWarnings("serial")
public class UserNotFoundWrongPassException extends RuntimeException {

	public UserNotFoundWrongPassException() {
		super("the user does not exist or the password is incorrect");
		
	}
}