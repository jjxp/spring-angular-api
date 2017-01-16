package com.jgal.web.crud.angular.da;
 
import java.util.List;
 
import com.jgal.web.crud.angular.model.User;
 
public interface UserDAO {
    public List<User> getUsers();
    public Integer createUser(User user);
    public Integer updateUser(User user);
    public Integer deleteUser(String id);
    public void insertBatch();
}