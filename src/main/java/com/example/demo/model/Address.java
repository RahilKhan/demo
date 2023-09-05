package com.example.demo.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Address {
    private final String street;
    private String mutableStr;
    private final int zipcode;

    public Address(String street, int zipcode) {
        this.street = street;
        this.zipcode = zipcode;
    }

    public void setMutableStr(String mutableStr) {
        this.mutableStr = mutableStr;
    }

}
