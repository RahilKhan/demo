package com.example.demo.javafeatures.serialization.externalizationDemo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car  implements Externalizable{
    private int age;
    private String company;
    private int mnfYear;
    private int hp;
    private String model;
    public static Car test = new Car(0, "Test", 0000, 000, "Test model");
    public static String str = "test";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(age);
        out.writeObject(company);
        out.writeInt(mnfYear);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException {
        age = in.readInt();
        company = (String)in.readObject();
        mnfYear = in.readInt();
    }

}
