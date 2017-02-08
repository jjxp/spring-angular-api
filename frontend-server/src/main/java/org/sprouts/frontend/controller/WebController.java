package org.sprouts.frontend.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sprouts.frontend.model.Car;
import org.sprouts.frontend.model.ResponseObject;
import org.sprouts.frontend.model.User;
import org.sprouts.frontend.service.WebCarService;
import org.sprouts.frontend.service.WebUserService;

import io.swagger.annotations.Api;

@RestController
@Api
public class WebController {

	// Managed stub services --------------------------------------------------
	
	protected WebUserService webUserService;
	protected WebCarService webCarService;

	// Constructor ------------------------------------------------------------
	
	public WebController(String webUserService) {
		this.webUserService = new WebUserService(webUserService);
		this.webCarService = new WebCarService(webUserService);
	}
	
	// Requests intercepter ---------------------------------------------------
	
	@RequestMapping(value = "/user/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> userInfo() {
		List<User> result;
		
		result = webUserService.findAll();
		
		return result;
	}
	
	@RequestMapping(value = "/user/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject createUser(@RequestBody User user) throws Exception {
		ResponseObject result;
		
		result = webUserService.create(user);
		
		return result;
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject updateUser(@RequestBody User user) throws Exception {
		ResponseObject result;
		
		result = webUserService.update(user);
		
		return result;
	}
	
	@RequestMapping(value = "/user/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject deleteUser(@RequestBody String param) throws Exception {
		ResponseObject result;
		
		result = webUserService.delete(param);
		
		return result;
	}
	
	@RequestMapping(value = "/car/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> carInfo() {
		List<Car> result;
		
		result = webCarService.findAll();
		
		return result;
	}
	
	@RequestMapping(value = "/car/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject createCar(@RequestBody Car car) throws Exception {
		ResponseObject result;
		
		result = webCarService.create(car);
		
		return result;
	}
}
