package camt.se331.templeProject.service;

import camt.se331.templeProject.dao.UserDao;
import camt.se331.templeProject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public List<User> getUser() {
        return userDao.getUser();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User editUser(User user) {
        return userDao.editUser(user);
    }

    @Override
    public Boolean verifyUsernamePassword(String username, String password) {
        List<User> userList = userDao.getUser();
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getUsername().equals(username)&&userList.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
