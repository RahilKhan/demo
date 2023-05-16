package com.example.demo.concurrency.threads.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Service2 implements Runnable{

    CyclicBarrier cbr;

    public Service2(CyclicBarrier cbr){
        this.cbr = cbr;
    }

    @Override
    public void run() {

        System.out.println("Service2 : " + cbr.getNumberWaiting());
        while (true) {
            try {
                cbr.await();
            } catch (InterruptedException | BrokenBarrierException ex) {
                ex.printStackTrace();
            }
        }
    }


}
