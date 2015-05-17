package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.Contact;

import java.util.List;

/**
 * Created by Dell on 2/4/2558.
 */
public interface  ContactDao {
public Contact getContact();
public void editContact(Contact contact);
    public Contact addContact(Contact contact);
}
