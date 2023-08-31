package com.example.demo.javafeatures.Java17;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Truck  implements SealedVehicle{
    @Override
    public void engineInfo(){
        String engineDesc = """ 
                Tesla Truck ->
                The estimated maximum power of the Tesla Cybertruck Tri Motor is 600 kW (805 hp). 
                The estimated maximum torque is 1033 lb-ft. 
                The Tesla Cybertruck Tri Motor is all wheel drive and can accelerate from 0 to 62 miles per hour in an estimated 3.0 seconds.
                """;
        log.info(engineDesc);
    }
}
