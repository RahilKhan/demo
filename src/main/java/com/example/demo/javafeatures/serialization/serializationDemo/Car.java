package com.example.demo.javafeatures.serialization.serializationDemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    private int age;
    private String company;
    private int mnfYear;
    private int hp;
    private String model;
}
