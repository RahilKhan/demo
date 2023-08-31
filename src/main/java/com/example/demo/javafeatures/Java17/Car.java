package com.example.demo.javafeatures.Java17;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Car implements SealedVehicle {

    @Override
    public void engineInfo() {
        String engineDesc = """
                The 1498 cc Petrol engine generates a power of 113.18bhp@6300rpm and a torque of 143.8Nm@4500rpm.
                "Hyundai Creta is available in both Manual & Automatic transmission.
                """;
        log.info(engineDesc);
    }
}
