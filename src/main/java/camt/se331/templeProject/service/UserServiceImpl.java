package camt.se331.templeProject.service;

import camt.se331.templeProject.dao.UserDao;
import camt.se331.templeProject.entity.Role;
import camt.se331.templeProject.entity.User;
import camt.se331.templeProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * Created by Dell on 14/4/2558.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User addUser(User user) {
        Role role = new Role();
        role.setRoleName("registered user");
        user.getRoles().add(role);
        return userRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }


}
