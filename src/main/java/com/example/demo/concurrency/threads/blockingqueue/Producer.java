package com.example.demo.concurrency.threads.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<String> blockingQueue = null;

    public Producer(BlockingQueue blockingQueue) {
        super();
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i<=10;i++) {
                blockingQueue.add("e"+i);
                System.out.println("Added e"+i);
                Thread.sleep(1000);
            }
            for(int i = 11; i<=15;i++) {
                blockingQueue.add("e"+i);
                System.out.println("Added e"+i);
            }
        } catch (InterruptedException iex) {
            iex.getMessage();
        }
    }
}
