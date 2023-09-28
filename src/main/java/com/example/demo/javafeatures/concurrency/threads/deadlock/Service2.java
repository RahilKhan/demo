package com.example.demo.javafeatures.concurrency.threads.deadlock;

import com.example.demo.concurrency.threads.deadlock.RsrcA;
import com.example.demo.concurrency.threads.deadlock.RsrcB;

public class Service2 implements Runnable {

    RsrcA rsrcA;
    RsrcB rsrcB;

    public Service2(RsrcA rsrcA, RsrcB rsrcB) {
        this.rsrcA = rsrcA;
        this.rsrcB = rsrcB;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Thread-Service2");
        synchronized (rsrcB) {
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock on RsrcB");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " acquiring lock on RsrcA");
            synchronized (rsrcA) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on RsrcA");
            }
        }
    }
}
