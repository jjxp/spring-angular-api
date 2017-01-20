package com.sprouts.da;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sprouts.model.User;

@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {

	/**
	 * This method will find an User instance in the database by its email. Note
	 * that this method is not implemented and its working code will be
	 * automatically generated from its signature by Spring Data JPA.
	 */
	public User findByFirstName(String firstName);

}