package camt.se331.templeProject.service;

import camt.se331.templeProject.entity.Contact;

import java.util.List;

/**
 * Created by Dell on 2/4/2558.
 */
public interface ContactService {
    public Contact getContact ();
    public Contact editContact(Contact contact);
    public Contact addContact(Contact contact);
}
