package com.example.demo.java8.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class CallableExample implements Callable {
    @Override
    public Object call() throws Exception {

        log.info("Thread sleeping for 100ms");
        Thread.sleep(100);
        return "Msg returned from call()";
    }
}
