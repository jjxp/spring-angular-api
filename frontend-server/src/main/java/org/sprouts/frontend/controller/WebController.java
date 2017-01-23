package org.sprouts.frontend.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sprouts.frontend.model.ResponseObject;
import org.sprouts.frontend.model.User;
import org.sprouts.frontend.service.WebService;

@RestController
public class WebController {

	// Managed stub services --------------------------------------------------
	
	protected WebService webUserService;

	// Constructor ------------------------------------------------------------
	
	public WebController(String webUserService) {
		this.webUserService = new WebService(webUserService);
	}
	
	// Requests intercepter ---------------------------------------------------
	
	@RequestMapping(value = "users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> userInfo() {
		List<User> result;
		
		result = webUserService.findAll();
		
		return result;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject createUser(@RequestBody User user) throws Exception {
		ResponseObject result;
		
		result = webUserService.create(user);
		
		return result;
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject updateUser(@RequestBody User user) throws Exception {
		ResponseObject result;
		
		result = webUserService.update(user);
		
		return result;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject deleteUser(@RequestBody String param) throws Exception {
		ResponseObject result;
		
		result = webUserService.delete(param);
		
		return result;
	}
}
