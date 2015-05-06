package camt.se331.templeProject.repository;

import camt.se331.templeProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dell on 14/4/2558.
 */
public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String username);
  }
