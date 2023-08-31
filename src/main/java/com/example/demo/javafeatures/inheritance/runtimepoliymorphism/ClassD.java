package com.example.demo.javafeatures.inheritance.runtimepoliymorphism;

public class ClassD extends ClassB{

    @Override
    public void displayB(){
        System.out.println("displayD");
    }
    public void printB(){
        System.out.println("printD");
    }


    public static void main(String...args){
        ClassB b = new ClassD();
        b.displayB();
        b.printB();
//        super.printB();
    }
}
