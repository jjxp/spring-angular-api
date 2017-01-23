package org.sprouts.backend.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.sprouts.backend.da.UserDAO;
import org.sprouts.backend.model.User;

@Service("userService")
public class UserService {

	// Managed Data Access Objects --------------------------------------------
	
	@Autowired
	private UserDAO userDAO;
	
	// Simple CRUD Methods ----------------------------------------------------
	
	public Object doService(Object... args) throws Exception {
		Assert.notNull(args[0]);
		if (args[0].equals("insert")) {
			User result;

			result = (User) args[1];

			userDAO.save(result);

			return 1;

		} else if (args[0].equals("update")) {
			User result;

			result = (User) args[1];

			userDAO.save(result);

			return 1;

		} else if (args[0].equals("delete")) {
			User result;

			result = userDAO.findOne(Integer.valueOf((String)args[1]));

			userDAO.delete(result);

			return 1;

		} else if (args[0].equals("getAll")) {
			Collection<User> result;

			result = (Collection<User>) userDAO.findAll();

			return result;
		}
		return null;
	}
}