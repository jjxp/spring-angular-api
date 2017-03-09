package org.sprouts.backend.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sprouts.backend.model.Car;
import org.sprouts.backend.pojo.ResponseObject;
import org.sprouts.backend.service.CarService;

import io.swagger.annotations.Api;

@RestController
@Api
@RequestMapping("/car")
public class CarController extends AbstractController {

	@Autowired
	private CarService carService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Car> list() throws Exception {
		Collection<Car> result = carService.findAll();
		return result;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject create(@RequestBody Car car) throws Exception {
		return getResponseObject(carService.save(car));
	}
}