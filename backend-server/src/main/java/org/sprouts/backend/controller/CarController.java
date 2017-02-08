package org.sprouts.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sprouts.backend.model.Car;
import org.sprouts.backend.model.ResponseObject;
import org.sprouts.backend.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController extends AbstractController {

	@Autowired
	private CarService carService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> list() throws Exception {
		List<Car> result = (List<Car>) carService.findAll();
		return result;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject create(@RequestBody Car car) throws Exception {
		return getResponseObject(carService.save(car));
	}
}