package com.sprouts.da;
 
import java.util.List;

import com.sprouts.model.User;
 
public interface UserDAO {
    public List<User> getUsers();
    public Integer createUser(User user);
    public Integer updateUser(User user);
    public Integer deleteUser(String id);
    public void insertBatch();
}