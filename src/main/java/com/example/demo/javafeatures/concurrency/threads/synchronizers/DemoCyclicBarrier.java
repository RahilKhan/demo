package com.example.demo.javafeatures.concurrency.threads.synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Practical Example of CyclicBarrier:
 * Suppose you have a scenario where you want to simulate a race with multiple runners.
 * Each runner should start running, and you want to ensure that they all start at the same time
 * when the race begins.
 * You can use a CyclicBarrier to coordinate this:
 */
public class DemoCyclicBarrier {

    public static void main(String... args) {
        cyclicBarrierDemo(3);

    }

    public static void cyclicBarrierDemo(int threadCount) {
        CyclicBarrier latch = new CyclicBarrier(threadCount);

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " ready to run");
                    Thread.sleep(10000);
                    latch.await();
                    System.out.println("Thread " + Thread.currentThread().getId() + " has started running.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }

        System.out.println(" Back in main()");
    }

}
