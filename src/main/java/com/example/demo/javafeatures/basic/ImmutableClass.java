package com.example.demo.javafeatures.basic;

import com.example.demo.model.Address;
import com.example.demo.model.Profession;

import java.util.HashMap;
import java.util.Map;

public class ImmutableClass {

    private final int id;
    private final Address address;
    private final HashMap<String, String> metaMap;
    private  final Profession profession;

    public ImmutableClass(int id, Address address, HashMap<String, String> metaMap, Profession profession) {
        this.id = id;
        this.address = address;
        this.profession = profession;

        Map<String, String> tempMap = new HashMap<>();
        metaMap.forEach((k, v) -> tempMap.put(k, v));
        this.metaMap = (HashMap<String, String>) tempMap;
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public Profession getProfession() {
        return profession;
    }

    public HashMap<String, String> getMetaMap() {
        // Creating Map with HashMap reference
        Map<String, String> tempMap = new HashMap<>();
        this.metaMap.forEach((k, v) -> tempMap.put(k, v));
        return (HashMap<String, String>) tempMap;

//        return (HashMap<String, String>) metaMap.clone();
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "id=" + id +
                ", address=" + address +
                ", metaMap=" + metaMap +
                ", profession=" + profession +
                '}';
    }
}

