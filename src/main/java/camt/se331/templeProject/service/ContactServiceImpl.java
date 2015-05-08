package camt.se331.templeProject.service;

import camt.se331.templeProject.dao.ContactDao;
import camt.se331.templeProject.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dell on 2/4/2558.
 */
@Service
public class ContactServiceImpl implements ContactService{
@Autowired
    ContactDao contactDao;
    @Override
    public Contact getContact() {
        return contactDao.getContact();
    }

    @Override
    public void editContact(Contact contact) {
       contactDao.editContact(contact);
    }
}
