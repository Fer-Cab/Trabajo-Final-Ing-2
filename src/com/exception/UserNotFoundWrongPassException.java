package com.exception;


public class UserNotFoundWrongPassException extends RuntimeException {

	public UserNotFoundWrongPassException(String userId) {
		super("the user '" + userId + "' does not exist or the password is incorrect");
		
	}
}