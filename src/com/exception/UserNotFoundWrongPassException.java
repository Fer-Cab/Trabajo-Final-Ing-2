package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundWrongPassException extends RuntimeException {

	public UserNotFoundWrongPassException(String userId) {
		super("the user '" + userId + "' does not exist or the password is incorrect");
		
	}
}