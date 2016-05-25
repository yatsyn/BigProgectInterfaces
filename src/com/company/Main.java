package com.company;

public class Main {

    public static void main(String[] args) {

       while (true) {
            System.out.println("1 for adding");
            System.out.println("2 for Search");
            System.out.println("3 Print all");
            System.out.println("4 Print sorted menu");
            System.out.println("5 for delete");
            System.out.println("6 Edit menu");
            System.out.println("0 exit");
            System.out.println();

            int menu = InputChecker.returnValidIntFromScanner();

            BookFacade bookFacade = new BookFacadeImpl();

            switch (menu) {
                case 0:
                    return;
                case 1:
                    bookFacade.addContact();
                    break;
                case 2:
                    bookFacade.searchContact().print();
                    //search
                    break;
                case 3:
                    bookFacade.printAllContacts();
                    break;
                case 4:
                    bookFacade.sortContacts();
                    break;
                case 5:
                    bookFacade.removeContact();
                    //  remove contact
                    break;
                case 6:
                    //edit contact
                    bookFacade.editContact();
                    break;
                default:
                    //error message for unavailable point in menu
                    //System.out.println("wrong point in menu");
                    break;
            }

            // write your code here
        }
    }
}
