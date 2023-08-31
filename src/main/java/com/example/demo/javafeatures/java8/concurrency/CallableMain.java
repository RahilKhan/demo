package com.example.demo.javafeatures.java8.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class CallableMain {

    public static void main(String... args) throws ExecutionException, InterruptedException {
        CallableExample callableExample = new CallableExample();
        FutureTask futureTask = new FutureTask<>(callableExample);
        Thread t = new Thread(futureTask);
        t.start();
        log.info("ftask.get(); : {}", futureTask.get());

    }
}
