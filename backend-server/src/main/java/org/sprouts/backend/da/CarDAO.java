package org.sprouts.backend.da;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.sprouts.model.Car;
import org.sprouts.model.User;

import javax.transaction.Transactional;


@Transactional
public interface CarDAO extends CrudRepository<Car, Integer> {

    @Query("select count(c) from Car c where c.user = ?1")
    Integer getNumOfCars(User u);

}