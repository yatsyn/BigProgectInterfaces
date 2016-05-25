package com.company;

/**
 * Created by ivan on 4/14/16.
 */
public class BookFacadeImpl implements BookFacade {

    iBookService iBookService = new BookService();

    @Override
    public void addContact() {
        iBookService.addContact();
    }

    @Override
    public void removeContact() {
        iBookService.removeContact();
    }

    @Override
    public void editContact() {
        iBookService.editContact();
    }

    @Override
    public Contact searchContact() {
        return iBookService.searchContact();
    }

    @Override
    public void sortContacts() {
        iBookService.sortContacts();
    }

    @Override
    public void printAllContacts() {
        iBookService.printAllContacts();
    }
}
