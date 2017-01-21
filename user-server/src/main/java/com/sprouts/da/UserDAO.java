package com.sprouts.da;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sprouts.model.User;

@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {

}