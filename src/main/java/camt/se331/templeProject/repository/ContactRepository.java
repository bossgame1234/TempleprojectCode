package camt.se331.templeProject.repository;

import camt.se331.templeProject.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dell on 2/4/2558.
 */
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
