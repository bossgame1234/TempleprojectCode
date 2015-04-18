package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.User;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
public interface UserDao  {
public List<User> getUser();
public User getUserById(Long id);
public User addUser(User user);
public User editUser(User user);
}
