package com.example.demo.javafeatures.concurrency.threads.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Service2 implements Runnable {

    CountDownLatch cdl;

    public Service2(CountDownLatch cdl) {
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
        System.out.println("Services2 : " + cdl.getCount());

    }

}
