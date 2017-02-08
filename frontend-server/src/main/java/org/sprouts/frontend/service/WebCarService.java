package org.sprouts.frontend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.sprouts.frontend.model.Car;
import org.sprouts.frontend.model.ResponseObject;

@Service
public class WebCarService {

	// Rest template declaration ----------------------------------------------
	
	@LoadBalanced
	protected RestTemplate restTemplate = new RestTemplate();

	// Constructor ------------------------------------------------------------
	
	protected String serviceUrl;

	public WebCarService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	// Simulated service methods ----------------------------------------------
	
	public List<Car> findAll() {
		
		Car[] result = restTemplate.getForObject(serviceUrl + "/car/list", Car[].class);
		
		return Arrays.asList(result);
	}
	
	public ResponseObject create(Car car) {
		ResponseObject result;
		
		result = restTemplate.postForObject(serviceUrl + "/car/create", car, ResponseObject.class);
		
		return result;
	}
	
}
