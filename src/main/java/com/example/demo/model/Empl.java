package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Empl implements Comparable<Empl>{

    String name;
    Integer age;
    Double salary;


    @Override
    public int compareTo(Empl o) {
        return name.compareTo(o.getName());
    }
}
