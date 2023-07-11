package com.example.demo.model;

public class Address {
    private final String streat;
    private final int zipcode;

    public Address(String street, int zipcode) {
        this.streat = street;
        this.zipcode = zipcode;
    }

    public String getStreat() {
        return streat;
    }

//    public void setStreet(String street) {
//        this.street = street;
//    }

    public int getZipcode() {
        return zipcode;
    }

//    public void setZipcode(int zipcode) {
//        this.zipcode = zipcode;
//    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + streat + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
