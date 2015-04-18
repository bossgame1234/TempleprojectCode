package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.User;
import camt.se331.templeProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@Profile("db.dbUserDao")
@Repository
public class DbUserDao implements UserDao {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }
}
