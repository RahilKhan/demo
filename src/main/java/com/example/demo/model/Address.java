package com.example.demo.model;

import lombok.ToString;

@ToString
public class Address {
    private final String streat;
    private String mutableStr;
    private final int zipcode;

    public Address(String street, int zipcode) {
        this.streat = street;
        this.zipcode = zipcode;
    }

    public String getStreat() {
        return streat;
    }

//    public void setStreet(String streat) {
//        this.streat = streat;
//    }

    public int getZipcode() {
        return zipcode;
    }

//    public void setZipcode(int zipcode) {
//        this.zipcode = zipcode;
//    }


    public void setMutableStr(String mutableStr) {
        this.mutableStr = mutableStr;
    }

    public String getMutableStr(){
        return this.mutableStr;
    }

}
