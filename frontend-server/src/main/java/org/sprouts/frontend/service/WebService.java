package org.sprouts.frontend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.sprouts.frontend.model.ResponseObject;
import org.sprouts.frontend.model.User;

@Service
public class WebService {

	// Rest template declaration ----------------------------------------------
	
	@LoadBalanced
	protected RestTemplate restTemplate = new RestTemplate();

	// Constructor ------------------------------------------------------------
	
	protected String serviceUrl;

	public WebService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	// Simulated service methods ----------------------------------------------
	
	public List<User> findAll() {
		
		User[] result = restTemplate.getForObject(serviceUrl + "/user/list",
				User[].class);
		
		return Arrays.asList(result);
	}
	
	public ResponseObject create(User user) {
		ResponseObject result;
		
		result = restTemplate.postForObject(serviceUrl + "/user/create", user, ResponseObject.class);
		
		return result;
	}
	
	public ResponseObject update(User user) {
		ResponseObject result;
		
		result = restTemplate.postForObject(serviceUrl + "/user/update", user, ResponseObject.class);
		
		return result;
	}
	
	public ResponseObject delete(String param) {
		ResponseObject result;
		
		result = restTemplate.postForObject(serviceUrl + "/user/delete", param, ResponseObject.class);
		
		return result;
	}
	
}
