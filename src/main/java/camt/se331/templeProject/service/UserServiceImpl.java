package camt.se331.templeProject.service;

import camt.se331.templeProject.entity.User;
import camt.se331.templeProject.repository.RoleRepository;
import camt.se331.templeProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

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
        user.getRoles().add(roleRepository.findOne(2L));
        return userRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }


}
