package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Employee {

    private int id;
    private String name;
    private double salary;
    private int age;
    private String gender;
    private String department;
    private int yearOfJoining;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Employee emp = (Employee) obj;
        return (emp.getId() == this.id);
    }

    @Override
    public int hashCode(){
        return this.getId() + name.hashCode();
    }
}
