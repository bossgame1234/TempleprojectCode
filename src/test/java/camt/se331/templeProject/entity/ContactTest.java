package camt.se331.templeProject.entity;

import camt.se331.templeProject.dao.ContactDao;
import camt.se331.templeProject.service.ContactService;
import camt.se331.templeProject.service.ContactServiceImpl;
import camt.se331.templeProject.service.PictureUtil;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
/**
 * Created by SONY on 18/5/2558.
 */
public class ContactTest {
    @Before
    public void setUp(){

    }

    @Test
    public void testGetContact(){

        Contact contact = new Contact("Place", "053-0000000", "www.facebook.com/Temple");
        ContactDao contactDao = Mockito.mock(ContactDao.class);
        ContactService contactService = new ContactServiceImpl(contactDao);
        when(contactDao.getContact()).thenReturn(contact);
        assertThat(contactService.getContact().getContactPlace(), is("Place"));
        assertThat(contactService.getContact().getContactTel(), is("053-0000000"));
        assertThat(contactService.getContact().getContactFacebook(), is("www.facebook.com/Temple"));

    }

    @Test
    public void testEditContact(){

        Contact contact = new Contact("Place", "053-0000000", "www.facebook.com/Temple");
        ContactDao contactDao = Mockito.mock(ContactDao.class);
        ContactService contactService = new ContactServiceImpl(contactDao);
        contact.setContactTel("053-6666666");
        contact.setContactFacebook("www.facebook.com/temple5555555");
        contact.setContactPlace("Chiang Mai");
        when(contactDao.editContact(contact)).thenReturn(contact);
        assertThat(contactService.editContact(contact).getContactPlace(), is("Chiang Mai"));
        assertThat(contactService.editContact(contact).getContactTel(), is("053-6666666"));
        assertThat(contactService.editContact(contact).getContactFacebook(), is("www.facebook.com/temple5555555"));

    }
}
