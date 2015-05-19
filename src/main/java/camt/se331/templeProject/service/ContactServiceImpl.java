package camt.se331.templeProject.service;

import camt.se331.templeProject.dao.ContactDao;
import camt.se331.templeProject.entity.Contact;
import camt.se331.templeProject.entity.User;
import camt.se331.templeProject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Dell on 2/4/2558.
 */
@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    ContactDao contactDao;

    @Autowired
    ContactRepository contactRepository;
    public ContactServiceImpl(ContactDao contactDao){
        this.contactDao = contactDao;
    }

    public ContactServiceImpl(){}

    @Override
    public Contact getContact() {
        return contactDao.getContact();
    }

    @Override
    public Contact editContact(Contact contact) {
        return contactDao.editContact(contact);
    }

    @Override
    public Contact addContact(Contact contact) {

        final String username = "cartoon5019@gmail.com";
        final String password = "5492134322";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("username", "password");
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from-email@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("componentbased702@gmail.com"));
            message.setSubject("Testing Subject");
            message.setText("CONTACT,"
                    + "\n\n HELLO WORLD!");
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return contactDao.addContact(contact);
    }
}
