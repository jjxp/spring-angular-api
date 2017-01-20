package com.sprouts.controller;

import java.util.List;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprouts.model.User;
import com.sprouts.service.WebService;

@RestController
public class WebController {

	protected WebService accountsService;

	public WebController(String accountsService) {
		this.accountsService = new WebService(accountsService);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("accountNumber", "searchText");
	}

	@RequestMapping("/users")
	public List<User> userInfo() {
		List<User> result;
		
		result = accountsService.findAll();
		
		return result;
	}
}
