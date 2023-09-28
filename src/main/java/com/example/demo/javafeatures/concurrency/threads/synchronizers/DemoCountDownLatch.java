package com.example.demo.javafeatures.concurrency.threads.synchronizers;

import java.util.concurrent.CountDownLatch;

/**
 * Practical Example of CountdownLatch:
 * Suppose you have a situation where you want to coordinate multiple threads to perform some work concurrently,
 * and you want to wait for all threads to finish before proceeding with the main task.
 * You can use a CountDownLatch for this purpose:
 */
public class DemoCountDownLatch {

    public static void main(String... args) {
        int threadCount = 3;
        countdownlatch(threadCount);
    }

    public static void countdownlatch(int threadCount) {
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            Thread workerThread = new Thread(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " going to sleep, signifying working on some task");
                    Thread.sleep(10000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                System.out.println("Thread " + Thread.currentThread().getId() + " has completed its task.");
                latch.countDown();
            });
            workerThread.start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All threads have completed their tasks. Proceeding with the main task.");

    }

}
