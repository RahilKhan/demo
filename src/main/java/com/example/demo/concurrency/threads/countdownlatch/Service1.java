package com.example.demo.concurrency.threads.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Service1 implements Runnable {

    CountDownLatch cdl;

    public Service1(CountDownLatch cdl) {
        super();
        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
        cdl.countDown();
        System.out.println("Services1 : "+cdl.getCount());
    }

}
