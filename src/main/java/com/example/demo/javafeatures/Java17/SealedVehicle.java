package com.example.demo.javafeatures.Java17;

public sealed  interface SealedVehicle permits Car, Truck{
    public void engineInfo();
}
