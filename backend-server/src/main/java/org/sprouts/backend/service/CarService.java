package org.sprouts.backend.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sprouts.backend.da.CarDAO;
import org.sprouts.model.Car;
import org.sprouts.model.User;

import java.util.Collection;


@Service("carService")
public class CarService {

	// Managed Data Access Objects --------------------------------------------
	
	@Autowired
	private CarDAO carDAO;

	@Autowired
	private KieContainer kieContainer;
	
	// Simple CRUD Methods ----------------------------------------------------
	
	public Car findOne(int id) {
		Car result;
		
		result = carDAO.findOne(id);
		
		return result;
	}
	
	public Collection<Car> findAll() {
		Collection<Car> result;
		
		result = (Collection<Car>) carDAO.findAll();
		
		return result;
	}
	
	public int save(Car car) {
	    int res;
		KieSession kieSession = kieContainer.newKieSession("Session");
		kieSession.insert(car);
		kieSession.setGlobal("carService", this);

		try{
            kieSession.fireAllRules();
            carDAO.save(car);
            res = 1;
        }catch(Exception e){
		    res = 0;
        }
		
		return res;
	}
	
	public int delete(Car car) {
		carDAO.delete(car);
		
		return 1;
	}

	public int getNumOfCars(User u){
	    return carDAO.getNumOfCars(u);
    }
}