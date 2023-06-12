package com.example.demo.javafeatures.concurrency.threads.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceMain {

    public static void main(String... args) throws InterruptedException {

        ExecutorService executors = Executors.newFixedThreadPool(4);
        CyclicBarrier cbr = new CyclicBarrier(5);
        executors.submit(new Service1(cbr));
        executors.submit(new Service1(cbr));
        executors.submit(new Service2(cbr));
        executors.submit(new Service2(cbr));
        executors.submit(new Service2(cbr));
        executors.submit(new Service2(cbr));
        Thread.sleep(1000);
        System.out.println("Done");
    }

}