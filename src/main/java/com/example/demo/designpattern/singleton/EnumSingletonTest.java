package com.example.demo.designpattern.singleton;

public class EnumSingletonTest {
    public static void main(String... args) {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.test();
    }
}
