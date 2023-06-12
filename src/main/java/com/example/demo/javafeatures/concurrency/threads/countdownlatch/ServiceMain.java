package com.example.demo.javafeatures.concurrency.threads.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceMain {

    public static void main(String... args) throws InterruptedException {

        ExecutorService executors = Executors.newFixedThreadPool(4);
        CountDownLatch cdl = new CountDownLatch(6);
        executors.submit(new Service1(cdl));
        executors.submit(new Service2(cdl));
        executors.submit(new Service2(cdl));
        cdl.await();
        System.out.println("Done");
    }

}
