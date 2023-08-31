package com.example.demo.javafeatures.basic.immutableExample;

import com.example.demo.model.Address;
import com.example.demo.model.Empl;
import com.example.demo.model.Employee;
import com.example.demo.model.Profession;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class ImmutableClass {

    private final int id;
    private final Address address;
    private final HashMap<String, String> metaMap;
    private final Profession profession;

    private Employee employee;

    public ImmutableClass(int id, Address address, HashMap<String, String> metaMap, Profession profession, Employee employee) {
        this.id = id;
        this.address = address;
        this.profession = profession;

        /** Required : for scenario : hm.put("t3", "v3");*/
        Map<String, String> tempMap = new HashMap<>();
        metaMap.forEach((k, v) -> tempMap.put(k, v));
        this.metaMap = (HashMap<String, String>) tempMap;

        /** Required : for scenario : employee.setDepartment("Mutable");*/
        this.employee = new Employee(employee.getId(), employee.getName(), employee.getSalary(), employee.getAge(),
                employee.getGender(), employee.getDepartment(), employee.getYearOfJoining());

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

    public Employee getEmployee(){
        /** Deep cloning to test immutability*/
        return new Employee(employee.getId(), employee.getName(), employee.getSalary(), employee.getAge(),
                employee.getGender(), employee.getDepartment(), employee.getYearOfJoining());
    }

}

