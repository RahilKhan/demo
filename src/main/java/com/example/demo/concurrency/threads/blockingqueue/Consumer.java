package com.example.demo.concurrency.threads.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    BlockingQueue<String> blockingQueue = null;

    public Consumer(BlockingQueue blockingQueue) {
        super();
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed : " + blockingQueue.take());
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
    }
}
