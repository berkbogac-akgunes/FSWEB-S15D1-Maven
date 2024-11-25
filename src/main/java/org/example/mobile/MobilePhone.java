package org.example.mobile;

import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) != -1) {
            return false;
        } else {
            myContacts.add(contact);
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (findContact(oldContact) != -1) {
            myContacts.remove(oldContact);
            myContacts.add(newContact);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact) != -1) {
            myContacts.remove(contact);
            return true;
        } else {
            return false;
        }
    }

    public Contact queryContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return myContacts.get(i);
            }
        }
        return null;
    }

    public void printContact() {
        System.out.println(myContacts);
    }

    public int findContact(Contact contact) {
            return myContacts.indexOf(contact);
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);

            if (contact.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}
