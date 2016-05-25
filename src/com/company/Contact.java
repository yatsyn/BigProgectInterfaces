package com.company;

/**
 * Created by ivan on 4/2/16.
 */
public class Contact implements iPrintable{
    private String name;
    private String number;
    private String date;


    public Contact() {
    }

    public Contact(String name, String number, String date) {
        this.name = name;
        this.number = number;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void print() {
        System.out.printf("%s\t%s\t%s\n",this.getName(),this.getNumber(), this.getDate());
    }
}
