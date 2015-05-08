package camt.se331.templeProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Dell on 2/4/2558.
 */
@Entity
public class Contact {

    @Id
    @GeneratedValue
    long contactId;
    String contactPlace;
    String contactTel;
    String contactFacebook;
    public Contact(){
    }
    public Contact(String contactPlace, String contactTel, String contactFacebook) {
        this.contactPlace = contactPlace;
        this.contactTel = contactTel;
        this.contactFacebook = contactFacebook;
    }
    public long getContactId() {
        return contactId;
    }

    public void setContactId(long id) {
        this.contactId = id;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getContactPlace() {
        return contactPlace;
    }

    public void setContactPlace(String contactPlace) {
        this.contactPlace = contactPlace;
    }

    public String getContactFacebook() {
        return contactFacebook;
    }

    public void setContactFacebook(String contactFacebook) {
        this.contactFacebook = contactFacebook;
    }
}
