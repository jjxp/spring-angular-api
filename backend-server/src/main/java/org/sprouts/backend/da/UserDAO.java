package org.sprouts.backend.da;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.sprouts.model.User;


@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {

}