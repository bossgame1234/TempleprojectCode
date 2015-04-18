package camt.se331.templeProject.controller;

import camt.se331.templeProject.entity.Contact;
import camt.se331.templeProject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dell on 2/4/2558.
 */
@RestController
@RequestMapping("/")
public class ContactController {
    @Autowired
    ContactService contactService;

    @RequestMapping(value = "Contact",method = RequestMethod.GET)
    public List<Contact> getContact(){
        return contactService.getContact();
    }

    @RequestMapping(value = "Contact",method = RequestMethod.PUT)
    public  void editContact(@RequestBody Contact Contact, BindingResult bindingResult){
        contactService.editContact(Contact);
    }

}
