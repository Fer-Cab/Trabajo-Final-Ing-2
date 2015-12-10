package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserExist extends RuntimeException {

	public UserExist(String userId) {
		super("the user '" + userId + "' already exist pick another one");
		
	}

}
