package com.sprouts.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sprouts.model.ResponseObject;
import com.sprouts.model.User;

@Service
public class WebService {

	@LoadBalanced
	protected RestTemplate restTemplate = new RestTemplate();

	protected String serviceUrl;

	public WebService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	public List<User> findAll() {
		
		User[] result = restTemplate.getForObject(serviceUrl + "/users",
				User[].class);
		
		return Arrays.asList(result);
	}
	
	public ResponseObject create(User user) {
		ResponseObject result;
		
		result = restTemplate.postForObject(serviceUrl + "/users", user, ResponseObject.class);
		
		return result;
	}
	
}
