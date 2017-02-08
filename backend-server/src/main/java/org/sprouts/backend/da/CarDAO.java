package org.sprouts.backend.da;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.sprouts.backend.model.Car;

@Transactional
public interface CarDAO extends CrudRepository<Car, Integer> {

}