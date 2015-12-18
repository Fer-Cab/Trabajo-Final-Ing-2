package com.exception;


public class UserExist extends RuntimeException {

	public UserExist(String userId) {
		super("the user '" + userId + "' already exist pick another one");
		
	}

}
