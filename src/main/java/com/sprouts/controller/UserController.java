package com.sprouts.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprouts.model.ResponseObject;
import com.sprouts.model.User;
import com.sprouts.service.ServiceFacade;
 
@RestController
public class UserController {
     
    @Autowired
    private ServiceFacade userService;
     
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> userInfo() throws Exception {
    	List<User> result = (List<User>) userService.doService("getAll");
        return result;
    }
     
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject createUser(@RequestBody User user) throws Exception {
        return getResponseObject((Integer) userService.doService("insert", user));
    }
     
    @RequestMapping(value = "/users", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject updateUser(@RequestBody User user) throws Exception {
        return getResponseObject((Integer) userService.doService("update", user));
    }
     
    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public ResponseObject deleteUser(@RequestBody String param) throws Exception {
    	String id = String.valueOf(Integer.parseInt(param.replaceAll("[\\D]", "")));
        return getResponseObject((Integer) userService.doService("delete", id));
    }
    
    private ResponseObject getResponseObject(Integer output){
        return new ResponseObject(output == 1 ? true : false, output == 1 ? "successful" : "failed");
    }
}