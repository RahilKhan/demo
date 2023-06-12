package com.example.demo.javafeatures.concurrency.threads.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Service1 implements Runnable{

    CyclicBarrier cbr;

    public Service1(CyclicBarrier cbr){
        this.cbr = cbr;
    }

    @Override
    public void run() {

        System.out.println("Service1 : " + cbr.getNumberWaiting());
        while (true) {
            try {
                cbr.await();
            } catch (InterruptedException | BrokenBarrierException ex) {
                ex.printStackTrace();
            }
        }
    }


}
