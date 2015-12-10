package com.controllers;

import com.exception.UserExist;
import com.exception.UserNotFoundWrongPassException;
import com.model.Account;
import com.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String createAccount(@RequestBody Account account ) {
		if(!accountService.existUserName(account.userName)){
		accountService.createAccount(account);
		return "user created";
		}
		else
			throw new UserExist(account.userName);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateAccount(@PathVariable("id") Long id,
			@RequestBody Account account) {
		accountService.updateAccount(account);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteAccount(@PathVariable("id") Long id) {

		accountService.deleteAccount(id);
	}
	
	
	
	@RequestMapping(value = "/log-in",method = RequestMethod.POST)
	public String  login(@RequestBody Account account) {
		if(accountService.userExist(account))
			return "user access granted";
					
		else
			throw new UserNotFoundWrongPassException(account.userName);
		
	}
	
}