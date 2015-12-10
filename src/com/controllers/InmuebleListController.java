package com.controllers;

import java.util.Collection;

import com.exception.UserNotFoundWrongPassException;
import com.model.InmuebleList;
import com.service.AccountService;
import com.service.InmuebleService;
import com.service.InmuebleListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{userId}/inmuebleList")
public class InmuebleListController {

	/*
	@Autowired
	private InmuebleListService inmuebleListService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private ProductService productService;

	private void validateUser(String userId) {
		accountService.findByUserName(userId);

		if (accountService.existUserName(userId)) {
		}

		else
			throw new UserNotFoundWrongPassException(userId);
	}

	@RequestMapping(method = RequestMethod.POST)
	void createCart(@PathVariable String userId) {
		this.validateUser(userId);
		
		inmuebleListService.createInmuebleList(
				new InmuebleList(accountService.findByUserName(userId)));
	}

	@RequestMapping(value = "/{inmuebleListId}", method = RequestMethod.GET)
	InmuebleList getInmuebleList(@PathVariable String userId,
			@PathVariable Long inmuebleListId) {
		validateUser(userId);

		return inmuebleListService.getInmuebleList(userId, inmuebleListId);
	}

	@RequestMapping(method = RequestMethod.GET)
	Collection<InmuebleList> getInmuebleList(@PathVariable String userId) {
		validateUser(userId);
		return inmuebleListService.findByAccountUsername(userId);
	}

	@RequestMapping(value = "/{inmuebleListId}/{productName}", method = RequestMethod.POST)
	public void addProduct(@PathVariable String userId,
			@PathVariable("inmuebleListId") Long inmuebleListId,
			@PathVariable("productName") String productName) {

		validateUser(userId);

		inmuebleListService.addProduct(userId, inmuebleListId,
				productService.getProductByName(productName));

	}

	@RequestMapping(value = "/{inmuebleListId}", method = RequestMethod.DELETE)
	public void deleteInmuebleList(@PathVariable String userId,
			@PathVariable("inmuebleListId") Long inmuebleListId) {
		
		validateUser(userId);

		inmuebleListService.deleteInmuebleList(inmuebleListId);
	}
*/
}
