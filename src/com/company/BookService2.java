package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by ivan on 4/2/16.
 */

public class BookService2 implements iBookService {

    List<Contact> contactArray = new ArrayList<>();

    @Override
    public void addContact() {
        contactArray.add(addTempContact());
    }

    @Override
    public void removeContact() {
        System.out.println("please, choose what contact we will remove?: ");

        Contact tempContact = searchContact();

        for (int i = 0; i < contactArray.size(); i++) {
            if (contactArray.get(i).getName() == tempContact.getName()
                    && contactArray.get(i).getNumber() == tempContact.getNumber()
                    && contactArray.get(i).getDate() == tempContact.getDate()) {
                contactArray.remove(i);
            }
        }
    }

    @Override
    public void editContact() {

        System.out.println("please, choose what contact we will edit?: ");

        Contact tempContact = searchContact();

        int i = contactArray.indexOf(tempContact);

        System.out.println("Choose what data do you need to edit:");

        while (true) {
            System.out.println("1 for edit name");
            System.out.println("2 for edit number");
            System.out.println("3 for edit date of birthday");
            System.out.println("0 for exit");

            int editMenuOption = InputChecker.returnValidIntFromScanner();

            switch (editMenuOption) {
                case 0:
                    return;

                case 1:
                    System.out.println("New name?");
                    tempContact.setName(InputChecker.returnValidStringFromScanner());
                    System.out.println("done");
                    break;
                case 2:
                    System.out.println("New number?");
                    tempContact.setNumber(InputChecker.returnValidStringFromScanner());
                    System.out.println("done");
                    break;
                case 3:
                    System.out.println("Date of birthday?");

                    System.out.println("day?");

                    int checkedDay = 0;
                    int checkedMonth = 0;
                    int checkedYear = 0;

                    int uncheckedDay = InputChecker.returnValidIntFromScanner();
                    if (uncheckedDay > 0 && uncheckedDay < 32) {
                        checkedDay = uncheckedDay;
                        break;
                    } else {
                        System.out.println("not valid day");
                    }

                    System.out.println("month?");

                    int uncheckedMonth = InputChecker.returnValidIntFromScanner();

                    if (uncheckedMonth > 0 && uncheckedMonth < 13) {
                        checkedMonth = uncheckedMonth;
                        break;
                    } else {
                        System.out.println("not valid month");
                    }

                    System.out.println("year?");

                    int uncheckedYear = InputChecker.returnValidIntFromScanner();

                    if (uncheckedYear < 3000) {
                        checkedYear = uncheckedYear;
                    } else {
                        System.out.println("not valid month");
                    }

                    if (checkedDay != 0 && checkedMonth != 0 && checkedYear != 0) {
                        tempContact.setDate(dateToString(checkedDay, checkedMonth, checkedYear));
                    }
            }
            break;
        }

        contactArray.set(i, tempContact);
    }

    @Override
    public Contact searchContact() {

        Contact findThisContactByOneValue = new Contact("Contact", " Not", " Found");

        while (true) {
            System.out.println("Choose search option:");
            System.out.println("1 for Search by name");
            System.out.println("2 for Search by number");
            System.out.println("3 for Search by date");
            System.out.println("0 exit");
            System.out.println();
            int searchOption = InputChecker.returnValidIntFromScanner();
            switch (searchOption) {
                case 0:
                    return findThisContactByOneValue;
                case 1:
                    System.out.println("Enter Name please (enter -1 for exit):");
                    String name = InputChecker.returnValidStringFromScanner();
                    findThisContactByOneValue.setName(name);
                    break;
                case 2:
                    System.out.println("Enter number please (enter -1 for exit):");
                    String number = InputChecker.returnValidStringFromScanner();
                    findThisContactByOneValue.setNumber(number);
                    break;
                case 3:
                    findThisContactByOneValue.setDate(setDateInString());
                    break;
                default:
                    System.out.println("wrong point in menu");
                    break;
            }

            for (int i = 0; i < contactArray.size(); i++) {
                if (contactArray.get(i).getName() == findThisContactByOneValue.getName()
                        && contactArray.get(i).getNumber() == findThisContactByOneValue.getNumber()
                        && contactArray.get(i).getDate() == findThisContactByOneValue.getDate()) {
                    return contactArray.get(i);
                }
                return findThisContactByOneValue;
            }
        }
    }

    @Override
    public void sortContacts() {

        while (true) {
            System.out.println("Choose search option:");
            System.out.println("1 for Sort by name");
            System.out.println("2 for Sort by number");
            System.out.println("3 for Sort by date");
            System.out.println("0 exit");
            System.out.println();
            int searchOption = Integer.valueOf((InputChecker.returnValidIntFromScanner()));
            switch (searchOption) {
                case 0:
                    return;
                case 1:
                    String[] sortByName = new String[contactArray.size()];


                    for (int i = 0; i < sortByName.length; i++) {
                        sortByName[i] = contactArray.get(i).getName();
                    }

                    Arrays.sort(sortByName);

                    for (int k = 0; k < sortByName.length; k++) {
                        for (int i = 0; i < contactArray.size(); i++) {
                            if (sortByName[k].equals(contactArray.get(i).getName())) {
                                printString(contactArray.get(i), i);
                            }
                        }
                    }
                    break;
                case 2:
                    String[] sortByNumber = new String[contactArray.size()];


                    for (int i = 0; i < sortByNumber.length; i++) {
                        sortByNumber[i] = contactArray.get(i).getNumber();
                    }

                    Arrays.sort(sortByNumber);

                    for (int k = 0; k < sortByNumber.length; k++) {
                        for (int i = 0; i < contactArray.size(); i++) {
                            if (sortByNumber[k].equals(contactArray.get(i).getNumber())) {
                                printString(contactArray.get(i), i);
                            }
                        }
                    }
                    break;
                case 3:
                    String[] sortByDateOfBirth = new String[contactArray.size()];

                    for (int i = 0; i < sortByDateOfBirth.length; i++) {
                        sortByDateOfBirth[i] = contactArray.get(i).getDate();
                    }

                    Arrays.sort(sortByDateOfBirth);

                    for (int k = 0; k < sortByDateOfBirth.length; k++) {
                        for (int i = 0; i < contactArray.size(); i++) {
                            if (sortByDateOfBirth[k].equals(contactArray.get(i).getDate())) {
                                printString(contactArray.get(i), i);
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("wrong point in menu");
                    break;
            }
        }


    }

    @Override
    public void printAllContacts() {
//        for (int i = 0; i < contactArray.size(); i++) {
//            printString(contactArray.get(i), i);
//        }
        for (Contact c : contactArray)   {
            c.print();
        }
    }

    private static String dateToString(int y, int m, int d) {
        String s = y + "-";
        if (String.valueOf(m).length() == 1) {
            s += "0";
        }
        s += m + "-";
        if (d < 10) {
            s += "0";
        }
        s += d;
        return s;
    }

//    private Contact[] createArrayForSorting(Contact[] arrayForSorting) {
//
//        int n = 0;
//        for (int i = 0; i < arrayOfContacts.getContactArray().length; i++) {
//
//            if (arrayOfContacts.getContactArray()[i] != null) {
//                arrayForSorting[n] = new Contact(arrayOfContacts.getContactArray()[i].getName(),
//                        arrayOfContacts.getContactArray()[i].getNumber(),
//                        arrayOfContacts.getContactArray()[i].getDate());
//                n++;
//            }
//        }
//        return arrayForSorting;
//
//    }

    private void printString(Contact contact, int id) {
        System.out.printf("%d\t%s\t%s\t%s\n", id + 1, contact.getName(), contact.getNumber(),
                contact.getDate());
        contact.print();
    }

    private Contact addTempContact() {
        System.out.println("Adding new contact");
        System.out.println("Name?");
        String name = InputChecker.returnValidStringFromScanner();

        System.out.println("Number?");
        String number = InputChecker.returnValidStringFromScanner();

        System.out.println("Date of birthday?");

        System.out.println("day?");

        int d = 0;

        while (d == 0) {
            int uncheckedDay = InputChecker.returnValidIntFromScanner();
            if (uncheckedDay > 0 && uncheckedDay < 32) {
                d = uncheckedDay;
            } else {
                System.out.println("not valid day");
            }
        }

        System.out.println("month?");

        int m = 0;

        while (m == 0) {
            int uncheckedMonth = InputChecker.returnValidIntFromScanner();

            if (uncheckedMonth > 0 && uncheckedMonth < 13) {
                m = uncheckedMonth;
            } else {
                System.out.println("not valid month");
            }
        }

        System.out.println("year?");

        int y = 3000;

        while (y == 3000) {
            int uncheckedYear = InputChecker.returnValidIntFromScanner();

            if (uncheckedYear < 3000) {
                y = uncheckedYear;
            } else {
                System.out.println("not valid month");
            }
        }

        String s = y + "-";
        if (String.valueOf(m).length() == 1) {
            s += "0";
        }
        s += m + "-";
        if (d < 10) {
            s += "0";
        }
        s += d;

        return new Contact(name, number, s);
    }

    private String setDateInString() {

        System.out.println("day?");

        int findThisDay = 0;

        while (findThisDay == 0) {
            int uncheckedDay = InputChecker.returnValidIntFromScanner();
            if (uncheckedDay > 0 && uncheckedDay < 32) {
                findThisDay = uncheckedDay;
            } else {
                System.out.println("not valid day");
            }
        }

        System.out.println("month?");

        int findThisMonth = 0;

        while (findThisMonth == 0) {
            int uncheckedMonth = InputChecker.returnValidIntFromScanner();

            if (uncheckedMonth > 0 && uncheckedMonth < 13) {
                findThisMonth = uncheckedMonth;
            } else {
                System.out.println("not valid month");
            }
        }

        System.out.println("year?");

        int findThisYear = 3000;

        while (findThisYear == 3000) {
            int uncheckedYear = InputChecker.returnValidIntFromScanner();

            if (uncheckedYear < 3000) {
                findThisYear = uncheckedYear;
            } else {
                System.out.println("not valid month");
            }
        }

        if (findThisDay != 0 && findThisMonth != 0 && findThisYear != 0) {
            return dateToString(findThisDay, findThisMonth, findThisYear);
        }
        return "null";
    }

}
