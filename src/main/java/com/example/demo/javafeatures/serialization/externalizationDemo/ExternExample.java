package com.example.demo.javafeatures.serialization.externalizationDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternExample {
    public static String FILEPATH = "car.txt";

    public static void main(String... args) {
        Car car = new Car(5, "Honda", 2023, 180, "Honda Civic");
        Car newCar = null;

        /* Serialize */
        try {
            FileOutputStream fos = new FileOutputStream(FILEPATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(car);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Deserialize */
        try {
            FileInputStream fis = new FileInputStream(FILEPATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            newCar = (Car) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(newCar.toString());

    }
}
