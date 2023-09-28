package com.example.demo.javafeatures.concurrency.threads.deadlock;

import com.example.demo.concurrency.threads.deadlock.RsrcA;
import com.example.demo.concurrency.threads.deadlock.RsrcB;

public class Service1 implements Runnable {

    RsrcA rsrcA;
    RsrcB rsrcB;

    public Service1(RsrcA rsrcA, RsrcB rsrcB) {
        this.rsrcA = rsrcA;
        this.rsrcB = rsrcB;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Thread-Service1");
        synchronized (rsrcA) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " acquired lock on RsrcA");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " acquiring lock on RsrcB");
            synchronized (rsrcB) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on RsrcB");
            }

        }
    }
}
