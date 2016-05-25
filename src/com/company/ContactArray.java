package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 4/2/16.
 */
public class ContactArray {


    private static List<Contact> contactArray = new ArrayList<>();

    ContactArray() {
    }

//    public ArrayList<Contact> getContactArray() {
//        return (ArrayList<Contact>) contactArray;
//    }

    public List<Contact> getArrayListOfContact() {
//        if (contactArray == null) {
//            contactArray = new ArrayList<>();
//        }
        return contactArray;
    }
}
