package com.sprouts.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sprouts.da.UserDAO;
import com.sprouts.model.User;
 
@Service("userService")
public class UserService implements ServiceFacade {
     
    @Autowired
    private UserDAO userDAO;
     
    public Object doService(Object... args) throws Exception {
        Assert.notNull(args[0]);
        if(args[0].equals("insertBatch")){
            userDAO.insertBatch();
            return true;
        }else if(args[0].equals("insert")){
            return userDAO.createUser((User)args[1]);
             
        }else if(args[0].equals("update")){
            return userDAO.updateUser((User)args[1]);
             
        }else if(args[0].equals("delete")){
            return userDAO.deleteUser((String)args[1]);
             
        }else if(args[0].equals("getAll")){
            return userDAO.getUsers();
        }
        return null;
    }
}