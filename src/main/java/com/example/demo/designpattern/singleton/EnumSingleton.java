package com.example.demo.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;

@Slf4j
public enum EnumSingleton {
    INSTANCE;

    public  static  void test(){
        log.info("Time --> {}", LocalTime.now());
    }
}
