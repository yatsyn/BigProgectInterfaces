package com.company;

/**
 * Created by ivan on 4/14/16.
 */
public interface BookFacade {
    public void addContact();
    public void removeContact();
    public void editContact();
    public Contact searchContact();
    public void sortContacts();
    public void printAllContacts();
}
