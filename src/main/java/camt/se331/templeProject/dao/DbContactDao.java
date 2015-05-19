package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.Contact;
import camt.se331.templeProject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dell on 2/4/2558.
 */
@Profile("db.dbContactDao")
@Repository
public class DbContactDao implements ContactDao{
    @Autowired
    ContactRepository contactRepository;
    @Override
    public Contact getContact() {
        return contactRepository.findOne(1L);
    }

    @Override
    public Contact editContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }
}
