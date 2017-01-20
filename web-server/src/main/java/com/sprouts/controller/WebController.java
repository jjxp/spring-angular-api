package com.sprouts.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprouts.model.ResponseObject;
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

	@RequestMapping(value = "users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> userInfo() {
		List<User> result;
		
		result = accountsService.findAll();
		
		return result;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject createUser(@RequestBody User user) throws Exception {
		ResponseObject result;
		
		result = accountsService.create(user);
		
		return result;
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject updateUser(@RequestBody User user) throws Exception {
ResponseObject result;
		
		result = accountsService.create(user);
		
		return result;
	}
}
